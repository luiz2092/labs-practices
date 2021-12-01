/**
 * 
 */
package com.avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.reflect.ReflectDatumReader;
import org.apache.avro.reflect.ReflectDatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.util.ResourceUtils;

import com.avro.model.UserCustom;
//import com.avro.model.User;

/**
 * @author luizd
 *
 */
public class AvroSpecificApp {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

//		User user = new User();
//
//		user.setName("Alyssa");
//		user.setFavoriteNumber(256);
//		user.setFavoriteColor("blue");
//
//		Schema schema = new Schema.Parser().parse(new File("src/main/resources/user.avsc"));
//
//		DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
//
//		DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
//		dataFileWriter.create(schema, new File("usersModel.avro"));
//
//		for (int i = 0; i < 3; i++) {
//			dataFileWriter.append(user);
//		}
//
//		dataFileWriter.close();

		UserCustom user = new UserCustom();

		user.setName("Alyssa");
		user.setFavoriteNumber(256);
		user.setFavoriteColor("blue");

		Schema schema = new Schema.Parser().parse(ResourceUtils.getFile("classpath:user.avsc"));

		DatumWriter<UserCustom> userDatumWriter = new ReflectDatumWriter<>(UserCustom.class);

		DataFileWriter<UserCustom> dataFileWriter = new DataFileWriter<UserCustom>(userDatumWriter);
		File temp = File.createTempFile("avroTest", "tmp.avro");
		temp.deleteOnExit();

		
		dataFileWriter.create(schema, temp);

		System.out.println(temp.getAbsolutePath());

		for (int i = 0; i < 10; i++) {
			dataFileWriter.append(user);
		}

		dataFileWriter.close();

		// Deserialize Users from disk
		DatumReader<UserCustom> userDatumReader = new ReflectDatumReader<UserCustom>(UserCustom.class);
		DataFileReader<UserCustom> dataFileReader = new DataFileReader<UserCustom>(temp, userDatumReader);
		UserCustom userRead = null;
		while (dataFileReader.hasNext()) {
			// Reuse user object by passing it to next(). This saves us from
			// allocating and garbage collecting many objects for files with
			// many items.
			userRead = dataFileReader.next(user);
			System.out.println(user);
		}

		dataFileReader.close();
	}

	public static <T> DatumWriter<T> datumWriterForClass(Class<T> clazz) {

		if (GenericRecord.class.isAssignableFrom(clazz)) {
			return new GenericDatumWriter<>();
		}

		if (SpecificRecordBase.class.isAssignableFrom(clazz)) {
			return new SpecificDatumWriter<>(clazz);
		}

		return new ReflectDatumWriter<T>();
	}
}

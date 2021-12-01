package com.avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;

public class AvroApplication {

	public static void main(String[] args) throws IOException {
		
		Schema schema = new Schema.Parser().parse(new File("src/main/resources/user.avsc"));
		GenericRecord user = new GenericData.Record(schema);

		user.put("name", "Alyssa");
		user.put("favorite_number", 256);
		user.put("favorite_color", "Blue");
		
		
		File file = new File("users.avro");
		DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
		DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
		dataFileWriter.create(schema, file);
		dataFileWriter.append(user);
		dataFileWriter.close();
		
	}

}

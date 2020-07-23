package org.azure.schema

import com.databricks.spark.avro.SchemaConverters
import org.apache.avro.{Schema, SchemaBuilder}
import org.apache.avro.data.RecordBuilder
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataType, StructType}

import scala.io.Source


object AvroConverter {

  def generateAvroSchemaFromJson(jsonPath: String): Unit =
  {

  }
  def main(args: Array[String]){

    val spark = SparkSession.builder
      .appName("SparkSessionExample")
      .master("local[4]")
      .getOrCreate

    val df = spark.read.option("multiline","true").json(getClass.getResource("/input1.json").getPath)

    val schema = DataType.fromJson(df.schema.json).asInstanceOf[StructType]
    val recordName: String = "EntityExample"
    val recordNamespace: String = "Test"
    val builder: SchemaBuilder.RecordBuilder[Schema] = SchemaBuilder.record(recordName).namespace(recordNamespace)
    val avroSchema = SchemaConverters.convertStructToAvro(schema,builder,recordNamespace)
    println(avroSchema)
  }
}

name := "AvroConverter"

version := "0.1"

scalaVersion := "2.10.6"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.2.3",
  "org.apache.spark" %% "spark-sql" % "2.2.2",
  "com.databricks" %% "spark-avro" % "4.0.0"
)


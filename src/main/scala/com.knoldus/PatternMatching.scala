package com.knoldus

object PatternMatching extends App {

  /**
   * Wildcard Pattern
   * Variable Pattern
   * Typed Pattern
   * Constant Pattern
   * Stable Identifiers
   * Tuple Pattern
   * Constructor Pattern
   * Sequence Pattern
   * Pattern Alternatives
   * Pattern Binders
   */

  // 1 --> Wildcard pattern
  val name = "something"
  name match {
    case _ => println("I can match anything")
  }

  // 2 --> Variable pattern
  def variablePattern(name : String) = name match {
    case n => println(s"My name is $n")
  }
  variablePattern("Knoldus")

  // 3 --> Typed Pattern
  val Name = "Kuldeepak"
  val age  = 22
  Name match {
    case name : String => println(s"Name entered is $name")
    case _ => println("Data Typed not matched")
  }

  // 4 --> Constant Pattern
  val event = "Knolx"
  event match {
    case "Knolx" => println("yeah it is Knolx")
  }

  def constantPattern(any : Any) = {
    any match {
      case "Knolx" => println("yeah it is Knolx")
      case 10 => println("OHhhhhhhhhh it's 10")
    }
  }
  constantPattern("Knolx")

  // 5 --> Stable Identifiers
  val clientName = "3TL"
  def verifyClient(name : String) = name match {
    case `clientName` => println(s"[Info] start working with $clientName")
  }
  verifyClient("3TL")

  // 6 --> Tuple Pattern
  def verifyTuplePattern(any: Any) = any match {
    case (_, "KG") => println("Wooowww KG")
    case (1, _ ) => println("Ranked 1")
    case _ => println("Unknown Data")
  }
  verifyTuplePattern(1, "MG")

  // 7 --> Constructor Pattern
  case class Knolx(name : String, topic : String, rank : Int)
  def verifyKnolx(any: Any) = any match {
    case Knolx(name, "SCALA", _) => println(s"Hi ${name} Department is Scala")
    case Knolx(_, _, 2) => println("Nice Attempt")
    case Knolx("Knolder", "SCALA", 1) => println("yuppss time to celebrate")
    case _ => println("Unformatted data")
  }

  verifyKnolx(Knolx("Kuldeepak", "SCALA", 1))
  verifyKnolx("verify Me")
  verifyKnolx(Knolx("Name", "Topic", 2))

  // 8 --> Sequence Pattern
  val seq = Seq(1, 2, 3, 4)
  seq match {
    case Seq(1, 2, 3) => println("Ooops")
    case x +: Nil => println("One element is stored")
    case _ :+ x => println(s"Last element is ${x}")
    case _ => println("Better Luck next time")
  }

  val list = List(1, 2, 3)
  list match {
    case List(1, _*) => println("Starting with 1")
  }

  // 9 --> Pattern Alternatives
  def verifyPatternAlternatives (any: Any) = any match {
    case Seq(1, 2, 3, 4) | Seq(1, 2, 3) => println("Sequence Matched !!")
    case  "Scala" | "SCALA" => println("Language Detected")
    case _ => println("Refer your friend")
  }
  verifyPatternAlternatives(Seq(1, 2, 3))

  // 10 --> Pattern Binders
  def patternBinders(any: Any) = any match {
    case knolx @ Knolx(name, _, 1) => println(s"Data Found $knolx")
    case _ => println("Try next Time")
  }
  patternBinders(Knolx("name", "topic", 1))

}
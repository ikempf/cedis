package io.cedis.commands

trait Command

object Command {
  case class Set(key: String, value: String)
}

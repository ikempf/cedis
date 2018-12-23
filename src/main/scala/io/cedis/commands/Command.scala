package io.cedis.commands

trait Command

object Command {
  case class Append(key: String, value: String)
  case class BitCount(key: String)
  case class BitField(key: String, arguments: String*)
  case class BitOp(bitOp: BitOp, key: String, srcKeys: String*)
  case class BitPos(key: String, value: Boolean)
  case class Decr(key: String)
  case class DecrBy(key: String, decrement: Long)
  case class Get(key: String)
  case class GetBit(key: String, offset: Long)
  case class GetRange(key: String, startOffset: Long, endOffset: Long)
  case class GetSet(key: String, value: String)
  case class Incr(key: String, value: String)
  case class IncrBy(key: String, value: Long)
  case class IncrByFloat(key: String, value: Double)
  case class Mget(keys: String*)
  case class Mset(keysValues: String*)
  case class Msetnx(keysValues: String*)
  case class Psetex(key: String, milliseconds: Long, value: String)
  case class Set(key: String, value: String)
  case class SetBit(key: String, offset: Long, value: Boolean)
  case class SetEx(key: String, seconds: Int, value: String)
  case class SetNx(key: String, value: String)
  case class SetRange(key: String, offset: Long, value: String)
  case class Strlen(key: String)
}

object Bitop {
  sealed trait BitOp
  case object And extends BitOp
  case object Or  extends BitOp
  case object Xor extends BitOp
  case object Not extends BitOp
}

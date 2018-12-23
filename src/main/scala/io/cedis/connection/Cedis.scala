package io.cedis.connection

import java.{lang, util}

import cats.effect.Sync
import redis.clients.jedis.{BitOP, Jedis}

import scala.collection.JavaConverters._

class Cedis[F[_]: Sync] private[connection] (jedis: Jedis) {

  def append(key: String, value: String): F[Long] =
    Sync[F].delay(jedis.append(key, value))

  def bitcount(key: String): F[Long] =
    Sync[F].delay(jedis.bitcount(key))

  def bitfield(key: String, arguments: String*): F[List[Long]] =
    Sync[F].delay(jedis.bitfield(key, arguments: _*).asScala.toList.map(Long2long))

  def bitop(bitOP: BitOP, key: String, srcKeys: String*): F[Long] =
    Sync[F].delay(jedis.bitop(bitOP, key, srcKeys: _*))

  def bitpos(key: String, value: Boolean): F[Long] =
    Sync[F].delay(jedis.bitpos(key, value))

  def decr(key: String): F[Long] =
    Sync[F].delay(jedis.decr(key))

  def decrBy(key: String, decrement: Long): F[Long] =
    Sync[F].delay(jedis.decrBy(key, decrement))

  def get(key: String): F[String] =
    Sync[F].delay(jedis.get(key))

  def getBit(key: String, offset: Long): F[Boolean] =
    Sync[F].delay(jedis.getbit(key, offset))

  def getrange(key: String, startOffset: Long, endOffset: Long): F[String] =
    Sync[F].delay(jedis.getrange(key, startOffset, endOffset))

  def getSet(key: String, value: String): F[String] =
    Sync[F].delay(jedis.getSet(key, value))

  def incr(key: String, value: String) =
    Sync[F].delay(jedis.incr(key))

  def incrBy(key: String, value: Long): F[Long] =
    Sync[F].delay(jedis.incrBy(key, value))

  def incrByFloat(key: String, value: Double): F[Double] =
    Sync[F].delay(jedis.incrByFloat(key, value))

  def mget(keys: String*): F[util.List[String]] =
    Sync[F].delay(jedis.mget(keys: _*))

  def mset(keysValues: String*): F[String] =
    Sync[F].delay(jedis.mset(keysValues: _*))

  def msetnx(keysValues: String*): F[Long] =
    Sync[F].delay(jedis.msetnx(keysValues: _*))

  def psetex(key: String, milliseconds: Long, value: String): F[String] =
    Sync[F].delay(jedis.psetex(key, milliseconds, value))

  def set(key: String, value: String): F[String] =
    Sync[F].delay(jedis.set(key, value))

  def setBit(key: String, offset: Long, value: Boolean): F[Boolean] =
    Sync[F].delay(jedis.setbit(key, offset, value))

  def setEx(key: String, seconds: Int, value: String): F[String] =
    Sync[F].delay(jedis.setex(key, seconds, value))

  def setNx(key: String, value: String): F[Long] =
    Sync[F].delay(jedis.setnx(key, value))

  def setRange(key: String, offset: Long, value: String): F[Long] =
    Sync[F].delay(jedis.setrange(key, offset, value))

  def strlen(key: String): F[Long] =
    Sync[F].delay(jedis.strlen(key))

}

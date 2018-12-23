package io.cedis.connection

import cats.effect.Sync
import redis.clients.jedis.Jedis

class Cedis[F[_]: Sync] private[connection] (jedis: Jedis) {

  def append(key: String, value: String): F[Long] =
    Sync[F].delay(jedis.append(key, value))

  def bitcount(key: String): F[Long] =
    Sync[F].delay(jedis.bitcount(key))

  def decr(key: String): F[Long] =
    Sync[F].delay(jedis.decr(key))

  def decrBy(key: String, decrement: Long): F[Long] =
    Sync[F].delay(jedis.decrBy(key, decrement))

  def get(key: String): F[String] =
    Sync[F].delay(jedis.get(key))

  def getBit(key: String, offset: Long): F[Boolean] =
    Sync[F].delay(jedis.getbit(key, offset))

  def decr(key: String, startOffset: Long, endOffset: Long): F[String] =
    Sync[F].delay(jedis.getrange(key, startOffset, endOffset))

  def getSet(key: String, value: String): F[String] =
    Sync[F].delay(jedis.getSet(key, value))

  def incr(key: String, value: String) =
    Sync[F].delay(jedis.incr(key))

  def incrBy(key: String, value: Long) =
    Sync[F].delay(jedis.incrBy(key, value))

  def incrByFloat(key: String, value: Double) =
    Sync[F].delay(jedis.incrByFloat(key, value))

  def mget(keys: String*) =
    Sync[F].delay(jedis.mget(keys: _*))

  def mset(keysValues: String*) =
    Sync[F].delay(jedis.mset(keysValues: _*))

  def msetnx(keysValues: String*) =
    Sync[F].delay(jedis.msetnx(keysValues: _*))

  def psetex(key: String, milliseconds: Long, value: String) =
    Sync[F].delay(jedis.psetex(key, milliseconds, value))

  def set(key: String, value: String): F[String] =
    Sync[F].delay(jedis.set(key, value))

  def setBit(key: String, offset: Long, value: Boolean) =
    Sync[F].delay(jedis.setbit(key, offset, value))

  def setEx(key: String, seconds: Int, value: String) =
    Sync[F].delay(jedis.setex(key, seconds, value))

  def setNx(key: String, value: String) =
    Sync[F].delay(jedis.setnx(key, value))

  def setRange(key: String, offset: Long, value: String) =
    Sync[F].delay(jedis.setrange(key, offset, value))

  def strlen(key: String) =
    Sync[F].delay(jedis.strlen(key))

}

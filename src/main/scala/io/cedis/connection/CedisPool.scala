package io.cedis.connection

import cats.effect.{Resource, Sync}
import redis.clients.jedis.JedisPool
import cats.syntax.functor._

object CedisPool {

  private def jedisPool[F[_]: Sync](host: String, port: Int): Resource[F, JedisPool] =
      Resource.fromAutoCloseable(Sync[F].delay(new JedisPool(host, port)))

  def apply[F[_]: Sync](host: String, port: Int): Resource[F, CedisPool[F]] =
    jedisPool(host, port).map(new CedisPool(_))

}

class CedisPool[F[_] : Sync] private (jedisPool: JedisPool) {

  def resource: Resource[F, Cedis[F]] =
    Resource.fromAutoCloseable(Sync[F].delay(jedisPool.getResource)).map(new Cedis(_))

}

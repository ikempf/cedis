package io.cedis

import cats.effect.{ExitCode, IO, IOApp}
import io.cedis.connection.CedisPool
import cats.syntax.functor._
import cats.syntax.apply._
import io.cedis.commands.Command.Append
import redis.clients.jedis.{JedisPool, JedisPoolConfig}

object Main extends IOApp {

  val pool = new JedisPool(new JedisPoolConfig, "localhost")

  override def run(args: List[String]): IO[ExitCode] = {
    CedisPool
      .apply[IO]("localhost", 6379)
      .use(pool => pool.resource.use(cedis =>
        cedis
          .set("key", "value")
          .productR(cedis.append("key", "value2"))
          .productR(cedis.get("key"))
          .map(println)
          .productR(cedis.execute(Append("key", "valueExecutor")))
          .productR(cedis.get("key"))
          .map(println)
      ))
      .as(ExitCode.Success)
  }

}

package io.cedis.execute
import io.cedis.commands.Command.Append
import io.cedis.connection.Cedis
import simulacrum.typeclass

@typeclass
trait Executor[A] {
  type B
  def execute[F[_]](cedis: Cedis[F], a: A): F[B]
}

object Executor {

  def apply[A, C]: Executor[A] = new Executor[A] {
    override type B = C
    override def execute[F[_]](cedis: Cedis[F], a: A): F[B] = ???
  }

  implicit val append: Executor[Append] = new Executor[Append] {
    override type B = Long
    override def execute[F[_]](cedis: Cedis[F], cmd: Append): F[B] =
      cedis.append(cmd.key, cmd.value)
  }

}

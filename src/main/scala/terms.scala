object terms:
  sealed trait Term

  sealed trait LambdaError

  case class Variable private(name: String) extends Term:
    override def toString: String = name

  case class VariableNamingError(name: String) extends LambdaError:
    override def toString: String = s"'$name' is incorrect naming for variable. Please, use only latin symbols!"

  object Variable:
    def apply(name: String): Either[LambdaError, Term] =
      if name.matches("^[a-zA-Z]+$") then
        Right(new Variable(name))
      else Left(VariableNamingError(name))

  case class Application(left: Term, right: Term) extends Term:
    override def toString: String = s"($left $right)"

  case class Abstraction(variable: Variable, body: Term) extends Term:
    override def toString: String = s"λ$variable.$body"

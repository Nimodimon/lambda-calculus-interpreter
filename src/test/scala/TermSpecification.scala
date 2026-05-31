import generators.{genInvalidVarName, genValidVarName}
import org.scalacheck.Prop.{forAll, propBoolean}
import org.scalacheck.Properties
import terms.Variable

class TermSpecification extends Properties("Term") {
  property("Variable with valid named should be created") = forAll(genValidVarName): (name: String) =>
    Variable(name).isRight

  property("Variables can not have non alphabetic symbols in the name") = forAll(genInvalidVarName): (name: String) =>
    Variable(name).isLeft

  property("Empty string is invalid name") = propBoolean:
    Variable("").isLeft
}

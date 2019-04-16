println("UW Complex Kotlin homework")

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15)
// use map to return a list with "", "FIZZ" or "BUZZ" as necessary
// use fold to compress the array of strings down into a single string
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ
//

fun getFizzBizz(start: Int, end: Int):String{
  return (start..end).toList().map{ num ->
    var ret=""
    if(num%3==0){
      if(num%5==0){
         ret="FIZZBUZZ"
      }else{
        ret= "FIZZ"
      }
    }else if(num%5==0){
       ret="BUZZ"
    }
    ret
  }.fold("",{fizzBuzz:String,str:String-> fizzBuzz+str})
}


val mapFoldResults=getFizzBizz(1,15)


// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit): Unit {
    for (it in 1..this) {
        block()
    }
}

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}
val r1 = process("FOO",{"BAR"}) // call process() with message "FOO" and a block that returns "BAR"

val r2_message = "wooga"
val r2 = process("FOO",{
  var str=""
  for(i in 1..3){
    str=str+r2_message.toUpperCase()
  }
  str
}) // call process() with message "FOO" and a block that upper-cases
            // r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"


// write an enum-based state machine between talking and thinking
enum class Philosopher {
  TALKING{
    override fun signal() = THINKING
    override fun toString() = "Allow me to suggest an idea..."
  },
  THINKING{
    override fun signal() = TALKING
    override fun toString() = "Deep thoughts...."

  };
  abstract fun signal(): Philosopher

}

// create an class "Command" that can be used as a function (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when called, the Command object should return a String containing the prompt and then the message
class Command(val prompt: String) {
  operator fun invoke(message:String):String{
    return this.prompt+message
  }
}


//FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ
//FIZZBUZZFIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ
// ================================
println("map fold test: " + if (mapFoldResults == "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ") "." else "!")

println("r1 test: " + if (r1 == ">>> FOO: {BAR}") "." else "!")

println("r2 test: " + if (r2 == ">>> FOO: {WOOGAWOOGAWOOGA}") "." else "!")

var seneca = Philosopher.THINKING
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")
print("Seneca, think! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Deep thoughts....") "." else "!")
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")

print("Command tests: ")
print(if (Command("")("") == "") "." else "!")
print(if (Command("> ")("Hello!") == "> Hello!") "." else "!")
println("")

println("Seneca the younger was a roman philosopher and playwright who's works laid the foundation for later generation's understanding of stoticism. Stoticism is a philosophical school that emphasizes an individuals need to live their life according to virtue whereby their actions would determine their morality.")

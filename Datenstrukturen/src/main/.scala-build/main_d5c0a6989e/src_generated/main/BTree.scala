

final class BTree$_ {
def args = BTree_sc.args$
def scriptPath = """BTree.sc"""
/*<script>*/
class BTree[A](initial: A):
  var inhalt: A = initial
  var links: BTree[A] = null
  var rechts: BTree[A] = null

  def  hoehe: Int = 
    hoeheH(this, 0)
  
  private def hoeheH(akt: BTree[A], counter: Int): Int = 
    if akt.links == null && akt.rechts == null then return counter
    if akt.rechts == null then return hoeheH(akt.links, counter + 1)
    if akt.links == null then return hoeheH(akt.rechts, counter + 1)
    val hl = hoeheH(akt.links, counter + 1)
    val hr = hoeheH(akt.rechts, counter + 1)
    if hl > hr then hl else hr
  
  def groesse: Int = 
    groesseH(this, 0)
  private def groesseH(akt: BTree[A], counter: Int): Int = 
    if akt == null then return counter
    val cl = groesseH(akt.links, counter)
    val cr = groesseH(akt.rechts, counter)
    cl + cr + 1

val b = BTree(5)
b.links = BTree(3)
b.rechts = BTree(8)

b.groesse // 3


/*</script>*/ /*<generated>*//*</generated>*/
}

object BTree_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new BTree$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export BTree_sc.script as `BTree`


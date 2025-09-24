// Geometrie als OOP-Fallstudie

// Aufgabe 1
// Definieren Sie eine immutable (das heißt: die Instanzen sollen nach der
// Konstruktion nicht veränderlich sein) Klasse Punkt mit zwei Double-
// Koordinaten x und y. Überschreiben Sie die toString-Methode so, dass
// ein Punkt in der Form (3.1 | 5) als String dargestellt wird.
// Ergänzen Sie eine Methode abstandZu(p: Punkt), die den Abstand von
// this zu p berechnet und zurückgibt.
case class Punkt(x: Double, y:Double):
  override def toString: String = s"$x / $y"
  def abstandZu(p: Punkt): Double = Math.sqrt((p.x - x)*(p.x - x) + (p.y - y)*(p.y - y))

val p1 = Punkt(2,3)
p1.toString
val p2 = Punkt(4,6)
p1.abstandZu(p2)
p1 abstandZu p2
// Begründen Sie, dass bei einer mutablen Klasse die Entscheidung zwischen
// private- und public-Attribute wichtiger ist als bei einer immutablen Klasse.

//Da eine immutable classeee nicht nur angesehen und nicht verändert werden kann während eine mutable classeeee public verändert werden kann

// Definieren Sie eine immutable Klasse Gerade, die durch zwei Punkte
// definiert wird. Überschreiben Sie die toString-Methode so, dass eine
// Gerade in der Form Gerade durch (3.1 | 5) und (2 | 2) als String
// dargestellt wird.

class Gerade(p1: Punkt, p2: Punkt):
  override def toString: String = s"Gerade durch ($p1 ) und ($p2 )"

val g1 = Gerade(p1, p2)
g1.toString

// Definieren Sie eine immutable Klasse Strecke, die durch zwei Punkte
// definiert wird. Überschreiben Sie die toString-Methode so, dass die
// Instanz in der Form Strecke von (3.1 | 5) nach (2 | 2) als String
// dargestellt wird. Ergänzen Sie eine Methode länge. Ergänzen Sie eine
// Methode mittelsenkrechte. Welchen Rückgabetyp muss diese Methode haben?

class Strecke(p1: Punkt, p2: Punkt):
  override def toString: String = s"Strecke von ($p1 ) nach ($p2 )"
  val mittelpunkt: Punkt = Punkt((p1.x + p2.x)/2, (p1.y + p2.y) / 2)
  def laenge: Double = p1.abstandZu(p2)
  val steigung: Double = (p2.y - p1.y) / (p2.x - p1.x)
  val normalenSteigung: Double = -1 / steigung
  def mittelsenkrechte: Gerade = Gerade(mittelpunkt, Punkt(mittelpunkt.x + 1,mittelpunkt.y + normalenSteigung ) )

// Definieren Sie eine immutable Klasse Kreis mit Mittelpunkt und Radius.
case class Kreis(r: Int, m: Punkt)




val k1 = Kreis.apply(10,Punkt(0,0))
val k2 = k1.copy(m=Punkt(1,1))


// Neuer Stoff: Nebenkonstruktoren ("secondary constructors")
// und Factory-Methoden.
// Die Klasse Kreis hat genau einen Konstruktor, eben den Klassenkopf.
// Implementieren Sie zwei weitere Möglichkeiten, Kreis-Instanzen zu
// konstruieren: Einmal mit einem "sekundären" Konstruktor, einmal mit einer
// Klassenmethode im Companion-Objekt der Klasse Kreis.

// Neuer Stoff: Vorgabeparameter, copy-Methode für immutable Klassen
// Instanzen immutabler Klassen kann man nicht verändern. Es ist aber hilreich,
// veränderte neue Instanzen erzeugen zu können. Dazu dient die copy-Methode.
// Sie hat Parameter

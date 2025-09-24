def indexVon(gesucht: Int, zuDurchsuchendesArray: Array[Int]): Int =
  var suchindex = 0   
  while suchindex < zuDurchsuchendesArray.length do
    if zuDurchsuchendesArray(suchindex) == gesucht then
      return suchindex
    else
      suchindex += 1
    return -1



/*Funktionsweise:
  Die Funktion durch dasläuft array mit
  while -Schleife und überprüft jedes Element.Wenn gesucht gefunden wird
, gibt die Funktion den aktuellen Index zurück.Wird gesucht nicht gefunden
, gibt die Funktion - 1.
  Wichtige Testfälle
•Wert ist vorhanden(normaler Fall)
•Wert kommt mehrfach vor (soll den ersten Index zurückgeben)
•Wert ist nicht vorhanden (-1)
•Leeres Array (-1)
Aufgabe
2*/



def maxWert(arr: Array[Int]): Int =
  var maxWert = arr(0)
  var index = 1
  while (index < arr.length) do
    if arr(index) > maxWert then
      maxWert = arr(index)
      index += 1
      maxWert






/*Funktionsweise:
  Funktion mit dem ersten Element im a Array
„maxWert
“und vergleicht dann jedes weitere Element in einer
while -Schleife.Wenn ein größeres Element gefunden wird
, aktualisiert sie
„maxWert
“.
Wichtigefälle Test
•Normales Array mit positiven und negativen Werten
•Array mit nur einem Element


Aufgabe
3*/


def maxIndex(arr: Array[Int]): Int =
  var maxIndex = 0
  var index = 1
  while (index < arr.length) do
    if arr(index) > arr(maxIndex) then
      maxIndex = index
      index += 1
      maxIndex
def maxIndex(arr: Array[Int]): Int



assert(maxIndex(a1)== -)

/*Funktionsweise
Die Funktion maxIndex = 0 und überprüft dann jedes Element des Arrays in einer
while -Schleife.Wenn ein Element größer als das aktuelle Maximum ist
, aktualisiert die Funktion den maxIndex.Bei einem leeren Array löst die Funktion eine Exception aus
.
Wichtige Testfälle
•Normales Array mit positiven Werten
•Array mit negativen Werten
•Einzelwert im Array

Aufgabe4*/


def arraySumme(summanden: Array[Int]): Int = {
  var summe = 0
  var index = 0
  while (index < summanden.length) do
    summe += summanden (index)
    index += 1
    summe
}



/*Funktionsweise
Die Funktion summe = 0 und geht dann jedes Element des Arrays in einer
while -Schleife durch
, wobei sie jedes Element zu summe addiert.
  Wichtigefälle Test
•Array mit positiven und negativen Werten
•Einzelwert
•Leeres Array( = 0
)*/

val a1=Array(-1,-4,-67,-8)
val a2=Array(65,4,12,98)

def arraysGleich(arr: Array[Int],arr2: Array[Int]): Boolean =
  if arr.length != arr2.length then
    return false
  else
    if arr.length ==0 then
      return true
    for EinzelneZahlenVergleichen <- 0 to (arr.length-1) do
      if arr(EinzelneZahlenVergleichen) != arr2(EinzelneZahlenVergleichen) then
        return false
    return true

  //assert(!arraysGleich(a1,a2))

def umdrehenInPlace(arr: Array[Int]):Unit =



def umdrehenNeu(arr: Array[Int]):Array[Int] =


def bubblesort( zs: Array[Int] ): Unit =
  // äußere Schleife:
  for abHierFertig <- zs.length to 2 by -1


val testarray = Array(6,5,4,3,2)
bubblesort(testarray)
gleicherArr (testarray)
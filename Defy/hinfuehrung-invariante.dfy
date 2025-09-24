// Filtered on Montag 2025-Juni-02 at 08:44:15 by Tippfilter 0.5-rc5-1-g51cbede (development or dirty build)
/* Übung "Programmfortschritt assert-en Teil 1"
Hier wird geübt, wie man die Änderung des Programmzustandes mit logischen 
Ausdrücken "verfolgt". Mit "Zustand" sind hier aus die Variablen des Programms,
gemeint: Jede Zeile ausführbaren Codes kann diesen Zustand ändern.

Arbeitsauftrag: Ergänzen Sie zwischen den ausführbaren Zeilen (weitere)
assert-ions, die den Zustand zum jeweiligen Ausführungszeitpunkt beschreiben.
Versuchen Sie möglichst aussagekräftige ("starke") Aussagen zu assert-en. */
method malZweiPlusDrei(x: int) returns (ergebnis: int)
  ensures ergebnis == x * 2 + 3
{
  // (a) Welche Aussage gilt hier?

  var zwischenergebnis := x * 2 ;

  // (b) Welche Aussage gilt hier?
  assert zwischenergebnis == x+x;

  ergebnis := zwischenergebnis + 3;

  // (c) Welche Aussage gilt hier?
  assert ergebnis == x+x+3;

  return ergebnis ;

  // (d) Welche Aussage gilt hier?

}


/* Übung "Programmfortschritt assert-en Teil 2"
In dieser Übung sollen a und b ihre Werte tauschen.
Der Einfachheit halber ist die Methode ohne Parameter formuliert und
tauscht die Werte von ab und b über eine "temp"oräre Variable.
Ergänzen Sie assert-s, die die Änderung der Variablenwerte verfolgen. Am
Schluss muss a==5 und b==17 gelten.
 */
method tauscheMitTemp()
{
  // (a) Welche Aussage gilt hier?

  var a := 17 ;

  // (b) Welche Aussage gilt hier?
  assert a==17;

  var b := 5 ;

  // (c) Welche Aussage gilt hier?
  assert a==17; 
  assert b==5;

  var temp := a ;

  // (d) Welche Aussage gilt hier?
  assert a==17; 
  assert b==5;
  assert temp==17; 
  
  a := b ;

  // (e) Welche Aussage gilt hier?
  assert a==5; 
  assert b==5;
  assert temp==17; 

  b := temp ;

  // (f) Welche Aussage gilt hier?
  assert a==5; 
  assert b==17;
  assert temp==17; 

  // Am Schluss muss gelten...:
  assert a == 5 && b == 17 ;
}



/* Übung "Programmfortschritt assert-en Teil 3"
Gleiche Aufgabe wie oben, nur ist der Code hier etwas raffinierter: 
Tauschen geht bei int-s nämlich auch ohne Zwischenspeicher-Variable.
Hier ist schon nicht mehr so ganz offensichtlich, dass und warum das
funktioniert.
Also ein guter Anlass, den Code zu verifizieren :-)*/
method tauscheOhneTemp()
{

  var a := 17 ;

  assert a==17; // TODO (a)
  
  var b := 5 ;

  assert b==5 ; // TODO (b)

  a := a + b ;

  assert a== 17+5 ; // TODO (c)

  b := a - b ;

  assert b==17+5-5 ; // TODO (d)

  a := a - b ;

  assert 17+5-(17+5-5) ; // TODO (e)

  // Am Schluss muss gelten...:
  assert a == 5 && b == 17 ;
}

/*
Übung "Programmfortschritt assert-en Teil 4":
Wie oben, aber für eine "abgewickelte" Schleife.
Abgewickelt heißt: Im Text stehen der Code aus dem Schleifenrumpf sowie
die Anpassung der Zählvariablen mehrmals hintereinander, dafür ohne
Schleifenkopf. 
Die Idee ist, dass man hier den Programmfortschritt in assert-s ausdrückt,
die Varianten voneinander sind -- und dann in Teil 5 den entscheidenden 
Schritt macht.
Arbeitsauftrag: */
method enthaelt_Abgewickelt(zahlen: array<int>, gesucht: int) 
  returns (gefunden: bool)
  /* als zusätzliche Vorbedingung nimmt man (etwas willkürlich) an, dass 
     Array z.B. genau drei Elemente hat. Das braucht man, damit die Schleife
     überhaupt abgewickelt werden kann (sonst wüsste man ja wieder nicht
     wie viele Durchläufe man hintereinander schreiben muss): */
  requires zahlen.Length == 3 
{
    var pos := 0;

    // TODO (a)

    if zahlen[pos] == gesucht {
      // #? tipp // hier weiß man etwas über pos UND etwas über das Array
      // TODO (b)
      return true;
    }

    // #? tipp // auch hier weiß man etwas über pos UND etwas über das Array!
    // #? tipp // Aber was?
    // TODO (c)

    pos := pos + 1;

    // TODO (d)

    if zahlen[pos] == gesucht {

      // TODO (e)
      return true;
    }

    // TODO (f)

    pos := pos + 1;

    // TODO (f)

    if zahlen[pos] == gesucht {

      // TODO (g)
      return true;
    }

    // TODO (h)

    pos := pos + 1;

    // TODO (i)

    return false; 
  }

/* Programmfortschritt 5: Formulieren Sie EINE logische Formel, die den 
Fortschritt in Nr. 4 ÜBERALL beschreibt: Egal an welche der Stellen a-i
man sie unverändert ("invariant") hinkopiert, Dafny muss überall in der
Lage sein sie zu beweisen. */
method enthaelt_Abgewickelt_mit_Invariante(zahlen: array<int>, gesucht: int) 
  returns (gefunden: bool)
  /* als zusätzliche Vorbedingung nimmt man (etwas willkürlich) an, dass 
     Array z.B. genau drei Elemente hat. Das braucht man, damit die Schleife
     überhaupt abgewickelt werden kann (sonst wüsste man ja wieder nicht
     wie viele Durchläufe man hintereinander schreiben muss): */
  requires zahlen.Length == 3 
{
    var pos := 0;

    // TODO (a)

    if zahlen[pos] == gesucht {
      // TODO (b)
      return true;
    }

    // TODO (c)

    pos := pos + 1;

    // TODO (d)

    if zahlen[pos] == gesucht {

      // TODO (e)
      return true;
    }

    // TODO (f)

    pos := pos + 1;

    // TODO (f)

    if zahlen[pos] == gesucht {

      // TODO (g)
      return true;
    }

    // TODO (h)

    pos := pos + 1;

    // TODO (i)

    return false; 
  }

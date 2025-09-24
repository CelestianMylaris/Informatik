// Filtered on Montag 2025-Februar-24 at 11:23:33 by Tippfilter 0.5-rc4-3-g3f1bba0 (development or dirty build)
//scalac -cp .:lib/greenfoot.jar *.scala
import greenfoot._

abstract class FahrzeugS( private var vMax: Int ) extends Actor:
   private var vMom: Int = 0
   def fahre1s(): Unit =
      move(vMom)
   def beschleunige(deltaV: Int): Unit =
      if vMom + deltaV > 0 then
         vMom += deltaV
         if vMom >= vMax then vMom = vMax
      else if vMom + deltaV > -(vMax/10) then vMom += deltaV
      else vMom = -(vMax/10)

   def getvMom = vMom

   def getvMax = vMax

   override def act(): Unit = 
      fahre1s()


class FahrradS(vMax: Int) extends FahrzeugS(vMax)


abstract class KfzS(val tankKapz: Double, val vMax: Int, val verbrauch: Double) extends FahrzeugS(vMax):
   private var tankinhalt: Double = 0
   
   def getTank = tankinhalt
   
   def tanke(menge: Int): Unit =
      tankinhalt += menge
      if getTank > tankKapz then tankinhalt = tankKapz
      if getTank < 0 then tankinhalt = 0
      
   override def beschleunige(deltaV: Int): Unit =
      if getTank > 0 then super.beschleunige(deltaV)
   
   override def fahre1s(): Unit =
      if tankinhalt >= verbrauch * getvMom then
         super.fahre1s()
         verbraucheTank
         
   def verbraucheTank =
      tankinhalt -= verbrauch * getvMom

class LKWS(bMax:int) extends KfzS(200.0, 80, 0.5):
   private var laderampeOffen = false
   protected var beladung = Array.ofDim[Ladegut_S](bMax)
   def istBeladen =
      beladung != null 
   def istLaderampeOffen = laderampeOffen

    /** Öffnet die Laderampe, aber nur wenn das Fahrzeug steht. */
   def oeffneLaderampe(): Unit =
      if getvMom == 0 then   
         this.setImage(new GreenfootImage("lasterLadeklappeOffen.png"))
         laderampeOffen = true 

   /** Schließt die Laderampe     */
   def schliesseLaderampe(): Unit =
      if getvMom == 0 then    
         laderampeOffen = false 
         this.setImage(new GreenfootImage("laster.png"))


    /** Verändert die Momentangeschwindigkeit. Beschleunigen ist aber nur
     * möglich, wenn die Laderampe geschlossen ist; sonst passiert gar nichts.*/
   override def beschleunige (deltaV: Int) =
      if !istLaderampeOffen then
         super.beschleunige(deltaV)

   /** Belädt das Fahrzeug mit einem Stück Fracht.
   * Es kann höchstens ein Frachtstück geladen werden. 
   * Der LKW lädt nur etwas ein, falls er noch nicht beladen ist UND falls die
   * Laderampe offen ist.
   * Das eingeladene Frachtstück wird beim Einladen in der Greenfoot-World
   * unsichtbar. 
   * 
   * @param frachtstueck Zeiger auf das Ladegut, das aufgenommen werden soll.
   * @return ob der Beladevorgang erfolgreich war, d.h. ob 
   * das angegebene Frachtstueck eingeladen werden konnte.     */
   def beladeMit (frachtstueck: Ladegut_S): Boolean =
      if istLaderampeOffen && !istBeladen then
         beladung = frachtstueck 
         this.getWorld().removeObject(frachtstueck)
         return true
      return false   

   /** Entlädt das Fahrzeug.
    * 
    * Die Funktion lädt das Ladegut aus dem Fahrzeug aus, falls eines drin ist.
    * Das Fahrzeug ist danach unbeladen.
    * 
    * Anschließend setzt die Methode das ausgeladene Ladegut neben der
    * Position dieses LKW in die Welt und macht es damit wieder sichtbar.
    *  
    * @return das Frachtstueck, das dieses Fahrzeug vorher 
    * geladen hatte; null, wenn dieses Fahrzeug leer war.     */
   def entlade(): Ladegut_S =
      if istLaderampeOffen && istBeladen then
         val tempaid = beladung
         beladung = null
         this.getWorld().addObject(tempaid , (this.getX() - 50) ,this.getY)
         return tempaid
      return null    


class PKWS extends KfzS(50, 100, 0.5)

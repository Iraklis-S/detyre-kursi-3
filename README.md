#  README për Aplikacionin JavaFX - Animimi i Imazhit

##  Përshkrim:
Ky aplikacion në JavaFX krijon një dritare interaktive që shfaq një imazh dhe mundëson manipulimin e tij përmes animimeve dhe ndërveprimeve të ndryshme me përdoruesin. Imazhi mund të rrotullohet, zbehet dhe të lëvizet në katër drejtime duke përdorur butona specifikë. Aplikacioni përdor **event handlers** dhe **animacione tranzicioni** për të krijuar një eksperiencë vizuale dinamike dhe ndërvepruese.

---

##  Qëllimi i Aplikacionit:
Ky aplikacion është krijuar për të demonstruar përdorimin e **JavaFX** në krijimin e **animimeve të imazheve** dhe **ndërveprimeve me mouse**. Ai ofron një shembull praktik të përdorimit të **RotateTransition**, **FadeTransition** dhe **TranslateTransition**, si dhe të trajtimit të ngjarjeve (`EventHandler`) për manipulimin e objekteve grafike.

---

## ⚙ Karakteristikat Kryesore:
- **Animimi i Rrotullimit:** Imazhi rrotullohet vazhdimisht kur **mouse** kalon mbi të.
- **Zbehja e Imazhit:** Imazhi zbehet gradualisht dhe rikthehet kur **mouse** kalon mbi të.
- **Lëvizja e Imazhit:** Përdoruesi mund të zhvendosë imazhin **majtas**, **djathtas**, **lart** dhe **poshtë** duke përdorur butona të dedikuar.
- **Ndërveprim Dinamik:** Kur **mouse** largohet nga imazhi, animacionet ndalojnë dhe imazhi mbetet në pozicionin aktual.

---

##  Kërkesat e Sistemit:
- Java JDK 17+
- JavaFX SDK 17+

---

##  Udhëzime për Ekzekutimin:

### 1. Kompilimi:
```bash
javac --module-path "C:\path\to\Java\javafx-sdk-x.x.x\lib" --add-modules javafx.controls,javafx.fxml -d bin src\Animimet.java

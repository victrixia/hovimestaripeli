#Tuntikirjanpito Hovimestarisimulaatiosta

13.1. n.4-5 tuntia plus luento. En tajunnut katsoa silloin kelloa. :P Githubiin rekisteröityminen, idean määrittely, netbeans-projektin luonti ja konffaus <p>
15.1. Jumankekka, unohdin näköjään laittaa tähän ajankäytön. Joku viitisen tuntia github-repon säätöä ja pushauksen harjoittelua, netbeansin konffauksen jatkoa, tarkempi idean määrittely ja README:hen tekstioksentaminen.<p>
19.1. nelisen tuntia taas. Luokkakaavion kanssa ohjelman rakenteen suunnittelua ja luokkien pyörittelyä paketista toiseen. Maveniin turhautumista. Alustavaa pelilogiikkaa ja vähän tekstikäyttöliittymää testausta varten. Ei vielä oikeita testejä - pitäisi uskaltaa yrittää!<p>
21.1. Parisen tuntia toiminnallisuuden lisäämistä Asiakas- ja Viini-luokkiin. Muutama testi lisätty plus manuaalista testausta. Kaikki ei taida nyt toimia vielä niinkuin pitää, mutta nyt on aika mennä nukkumaan... <p>
22.1. 4 tuntia. Testien kirjoittamista, pitin konffauksen korjausta, pit-generaatio. Aika paljon mutantteja menee vielä läpi, pitää korjata testejä! Luokkakaavion piirtäminen puhtaaksi photoshopilla. :P<p>
27.1. 3 tuntia lisäkoodausta (ruokalajien sovittaminen asiakkaan reaktioihin), lisätestien kirjoittamista ja vanhojen korjaamista/täydentämistä. <p>
28.1. 2 tuntia, lisätty random-toiminto viinien arpomiseen ja täydennetty tekstikäliä  ja pelilogiikkaa niin, että peli tarjoaa ruokalajille nyt kolme eri viinivaihtoehtoa ja kertoo asiakkaan reaktion. Reaktio kaipaa vielä 'pientä' hienosäätöä.<p>
29.1. 5 tuntia. Testien kirjoittamista, pientä hienosäätöä, luokkakaavion päivitys. Saattaa olla vähän vajaata, onnistuin sairastumaan influenssaan. ;; <p>

Pit on Peli-luokan kohdalla hiukan ongelmallinen. Pelilogiikka on lähinnä olioissa itsessään, Peli vain toimii välittäjänä käyttöliittymän ja olioiden välillä. Sen testaaminen on siis useimpien metodien kohdalla melko hankalaa (ne kun lähinnä kutsuvat käyttöliittymää tai jonkin olion jo muualla testattua metodia), enkä oikein tiedä, kuinka toteuttaa sitä. Vai onko se edes tarpeen? <p>
4.2. 4 tuntia. Testien refaktorointia ja graafisen käyttöliittymän aloitus. Ps. Swing on KAMALAA. Aargh. <p>
5.2. 3 tuntia. Hieman uusia testejä, javadocin kirjoittamista. Haluaisin olla käyttöliittymän kanssa pidemmällä, mutta viikonlopun ja alkuviikon tosi kipeänä => en juuri pystynyt koodaamaan. :/ Pitää ottaa ensi viikolla kiinni...<p>

11.2. 5 tuntia, käyttöliittymän kanssa tappelemista lähinnä. Nyt alkaa jo vähitellen hahmottua, mutta aika karmeen näköinen se on toki vielä, ja toiminnallisuutta ei juurikaan ole. Jostain syystä en saa käyttöliittymää toimimaan pelilogiikan kanssa yhteen, vaan hahmonluonti jää tapahtumatta. No jaa, sitä voi miettiä sitten kun luuranko on kasassa. <p>
12.2. 4 tuntia. Edistystä käyttöliittymän suhteen! Ei enää tunnu mielipuoliselta sekoilulta. Huzzah! Havaittu että pitää refaktoroida pelilogiikkaa siltä osin, että yksittäinen kierros on oma luokkansa - muuten ei saa käyttöliittymälle sopivia paluuarvoja välitettyä. Poisteltu paljon turhaa ja korjailtu testejä kattavammaksi. Kierroksen testausta ei nyt juuri ole koska seuraavaksi on kuitenkin tehtävä siitä oma luokkansa. Tehty myös pari sekvenssikaaviota ja päivitetty luokkakaavio (joka saattaa kyllä olla vähän sekava... ääk)<p>

17.2. 2 tuntia. Suosituksen implementointi graafiseen käyttöliittymään. <p>
18.2. 6 tuntia. Koodin refaktorointia - Kierroksesta oli tehtävä oma luokkansa jotta kommunikointi graafisen käyttöliittymän kanssa onnistuisi kunnolla, eikä asiakas vaihdu kesken aterian. Pelilogiikka meni siis osittain uusiksi, ja siihen tulee vielä uusia ominaisuuksia jotta pystytään siirtymään jouhevasti asiakkaasta toiseen. Testit ovat nyt rikki, pitäisi yrittää ehtiä nekin korjata. Uuugh. <p>
19.2. 7 tuntia. Armotonta koodausta peruspelitoiminnan saamiseksi juohevaksi. Kuvitus puuttuu, laitetaan viikonloppuna että on edes jotain kivaa demossa katseltavana. Testit korjattu, kattavuus näyttäisi olevan ok. Voi tosin olla että jotain on jäänyt huomiotta. Asiakkaita ei ole vielä kuin yksi, mutta ehkä demoon mennessä muutama lisää. Tippauslogiikkaa pitää ehkä hioa, nyt on aika avokätistä. Tai sitten vaan näin. <p>Sekvenssikaavioita ei nyt ole päivitetty, koska kello on vähän yli 5 aamulla ja huomenna on työpäivä. Sori! Luokkakaavio on kuitenkin ajantasaistettu. Ehkä jotain muutakin vielä tuli tehtyä mutta nukuttaa liikaa enkä muista enempää. 

 

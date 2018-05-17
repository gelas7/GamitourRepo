-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 17, 2018 at 01:43 PM
-- Server version: 5.7.22-0ubuntu0.16.04.1
-- PHP Version: 7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gamitour`
--

-- --------------------------------------------------------

--
-- Table structure for table `actividad`
--

CREATE TABLE `actividad` (
  `idactividad` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `fechainicio` date DEFAULT NULL,
  `fechafin` date DEFAULT NULL,
  `ubicacion` varchar(60) DEFAULT NULL,
  `numparticipantes` int(11) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `imagen` varchar(60) DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `actividad`
--

INSERT INTO `actividad` (`idactividad`, `nombre`, `fechainicio`, `fechafin`, `ubicacion`, `numparticipantes`, `precio`, `imagen`, `puntos`) VALUES
(9, 'Actividad', '2018-05-10', '2018-05-26', 'Gijon', 123, 112, '2018-05-08(06:14:44)-ok.jpg', 1123),
(10, 'De visita por Avilés', '2018-05-08', '2018-05-24', 'Aviles', 8, 10, '2018-05-09(08:13:25)-escudo.jpg', 100);

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `apellidos` varchar(60) DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `codigopostal` varchar(10) DEFAULT NULL,
  `avatar` varchar(45) DEFAULT NULL,
  `puntosacumulados` int(11) DEFAULT NULL,
  `fecharegistro` date DEFAULT NULL,
  `rol_idrol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`idcliente`, `nombre`, `apellidos`, `fechanacimiento`, `email`, `password`, `telefono`, `direccion`, `codigopostal`, `avatar`, `puntosacumulados`, `fecharegistro`, `rol_idrol`) VALUES
(29, 'Alfonso', 'del Busto', '1996-03-08', 'adelbustom@yahoo.com', 'contrasena', '999999999', 'Gijon', '33204', '2018-05-08(06:14:10)-ok.jpg', 100, '2018-05-08', 1),
(30, 'Miguel Angel', 'Alvarez Rivero', '1996-08-06', 'miguelaar96@gmail.com', 'javicaca', '122722822', 'C/ Menendez Valdes', '33120', '2018-05-08(10:36:28)-malta.png', 2000, '2018-05-08', 1),
(31, 'Admin', 'Turismo', '2001-01-01', 'turismo@admin.com', 'admin', '999222888', 'Gijon', '33222', '2018-05-08(10:35:32)-GOPR0957.JPG', 123, '2018-05-08', 1),
(32, 'Catalina', 'Riaño', NULL, 'catalinarg@cifpdeldeporte.es', '123456', NULL, NULL, NULL, '2018-05-14(06:05:49)-avatar.jpg', NULL, NULL, 1),
(33, 'Ana', 'Santos', NULL, 'ana.santos@cifphosteleriayturismo.es', '123456', NULL, NULL, NULL, '2018-05-14(06:05:56)-avatar.jpg', NULL, NULL, 1),
(34, 'Emilio', 'bb', '2018-05-14', 'emiliobb@cifpdeldeporte.es', '123456', '123456', 'cifpdeldeporte', '33400', '2018-05-14(06:05:33)-avatar.jpg', 0, '2018-05-14', 1),
(35, 'Estefania', 'sr', '2018-05-14', 'estefaniasr@cifpdeldeporte.es', '123456', '123123', 'cifpdedeporte', '33400', '2018-05-14(06:06:50)-avatar.jpg', 0, '2018-05-14', 1),
(36, 'Turismo', 'La Magdalena', '2018-05-14', 'turismolamagdalena@gmail.com', '123456', '123123', 'aviles', '33400', '2018-05-14(06:07:31)-avatar.jpg', 0, '2018-05-14', 1),
(37, 'Maria ', 'Baldonedo', '0218-05-14', 'mariabaldonedomosteiro@gmail.com', '123456', '985550511', 'C/Leopoldo Alas', '33201', '2018-05-14(12:41:06)-readme.txt', 1, '2018-05-14', 1),
(38, 'Maria Jesus', 'Campos', '2018-03-18', 'susicamposfirveda@hotmail.com', '123456', '685505149', 'A', '33201', '2018-05-15(12:15:19)-wordicon.exe', 1, '2018-05-15', 1);

-- --------------------------------------------------------

--
-- Table structure for table `cliente_has_actividad`
--

CREATE TABLE `cliente_has_actividad` (
  `cliente_idcliente` int(11) NOT NULL,
  `actividad_idactividad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `comentario`
--

CREATE TABLE `comentario` (
  `idcomentario` int(11) NOT NULL,
  `texto` varchar(200) DEFAULT NULL,
  `cliente_idcliente` int(11) NOT NULL,
  `multimedia_idmultimedia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `itinerario`
--

CREATE TABLE `itinerario` (
  `iditinerario` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `duracion` varchar(15) DEFAULT NULL,
  `ubicacion` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `itinerario`
--

INSERT INTO `itinerario` (`iditinerario`, `nombre`, `categoria`, `duracion`, `ubicacion`) VALUES
(33, 'Gijón, costa marinera', 'Deporte', '2 días.', 'Playa de San Lorenzo'),
(34, 'Aviles, un encuentro', 'cultural', '1', 'Aviles'),
(36, 'Ruta de Jovellanos', 'Cultural ', '...h', 'Gijón'),
(38, 'Avilés, un encuentro entre 2 mundos.', 'Cultural', '1 día', 'AVILÉS');

-- --------------------------------------------------------

--
-- Table structure for table `multimedia`
--

CREATE TABLE `multimedia` (
  `idmultimedia` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `comentario` varchar(60) DEFAULT NULL,
  `imagen` varchar(60) DEFAULT NULL,
  `video` varchar(60) DEFAULT NULL,
  `cliente_idcliente` int(11) NOT NULL,
  `pruebaDeportiva_idpruebadeportiva` int(11) NOT NULL,
  `puntosacumulados` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `noticia`
--

CREATE TABLE `noticia` (
  `idnoticia` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `texto` text,
  `fechaalta` date DEFAULT NULL,
  `fechacaducidad` date DEFAULT NULL,
  `imagen` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `noticia`
--

INSERT INTO `noticia` (`idnoticia`, `nombre`, `texto`, `fechaalta`, `fechacaducidad`, `imagen`) VALUES
(7, 'Noticia prueba', 'aaa', '2018-05-04', '2018-05-18', '2018-05-08(06:12:56)-ok.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `parada`
--

CREATE TABLE `parada` (
  `idparada` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `numeroParada` int(11) DEFAULT NULL,
  `ubicacion` text,
  `latitud` float DEFAULT NULL,
  `longitud` float DEFAULT NULL,
  `historia` text,
  `anecdotario` text,
  `gastronomia` text,
  `imagen` varchar(200) DEFAULT NULL,
  `video` varchar(200) DEFAULT NULL,
  `itinerario_iditinerario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `parada`
--

INSERT INTO `parada` (`idparada`, `nombre`, `numeroParada`, `ubicacion`, `latitud`, `longitud`, `historia`, `anecdotario`, `gastronomia`, `imagen`, `video`, `itinerario_iditinerario`) VALUES
(36, 'El ayuntamiento', 1, 'Aviles', 43.558, -5.9247, 'Algo de historia', 'Alguna anécdota', 'Gran comida', '2018-05-08(06:13:42)-ok.jpg', '2018-05-08(06:13:42)-20160712_160320000_iOS.jpg', 33),
(38, 'Ferreria', 2, 'Ferrería Avilés', 43.5565, -5.9214, '-', '-', '-', '2018-05-09(08:12:34)-calle.jpg', '2018-05-09(08:12:34)-calle.jpg', 34),
(41, 'Casa Natal ', 1, 'Plaza de Jovellanos, 33201 Gijón, Asturias', 43.5458, -5.6626, 'La noche del 5 de enero de 1744, en el Palacio de Gregorio García de Jove nació el escritor, jurista y político Gaspar Melchor Baltasar de Jovellanos, personaje vinculado al movimiento de la Ilustración.\r\nEstudió filosofía en Oviedo y en 1778 fue nombrado Alcalde de Casa y Corte, trasladándose a Madrid. Perteneció a la Orden de Alcántara y en 1797 fue nombrado Ministro de Gracia y Justicia.\r\nEl edificio se construyó entre el siglo XIV y el XVI y se corresponde con el modelo de casona palaciega asturiana con dos torres, cuerpo central y patio interior.\r\nEn su casa natal, convertida hoy en museo, Jovellanos redactó el Informe en el Expediente de Ley Agraria y en ella podemos contemplar el retrato oficial de Jovellanos encargado al pintor Suárez Llanos. Sin embargo, una de las obras más emblemáticas del museo es El Retablo del Mar, realizada por el artista Sebastián Miranda.\r\n', '… Jovellanos fue nombrado consejero de las Órdenes Militares y fue miembro de la Academia de la Historia, la Real Academia Española y la Academia de Bellas Artes de San Fernando?\r\n.… en el museo localizado en la Casa Natal de Jovellanos podemos contemplar arte asturiano (S. XIX y XX), pintura de las escuelas flamencas y holandesas (S.XVII y XVIII), pintura de vanguardia y escultura modernista?\r\n', '%', '2018-05-14(11:58:26)-casa natal Jovellanos.jpg', '2018-05-14(11:58:26)-Spot_48_Campana_2017_Vuelve_al_Paraiso._Ven_a_Asturias-2xpvH1Slqcg.mp4', 36),
(43, 'Escalerona - muro de San Lorenzo ', 4, 'Muro de San Lorenzo, 33202, Gijón (Asturias)', 43.5422, -5.6598, 'La Escalerona fue inaugurada en 1933 y se corresponde con la escalera nÂº 4, que junto a sus 24 compaÃ±eras, forman parte del Paseo del Muro de la playa de San Lorenzo, el cual nos recuerda la lucha constante entre el Mar CantÃ¡brico y la intenciÃ³n de GijÃ³n de expandirse. \r\nJovellanos describiÃ³ en su Plan de Mejoras para la ciudad los problemas de la acciÃ³n demoledora del mar y la arena en el desarrollo del proyecto, describiendo la necesidad de â??un paredÃ³n en lÃ­nea curva de mÃ¡s de 1000 varas de extensiÃ³n sobre la playa oriental para defender la poblaciÃ³n no sÃ³lo del mar, sino tambiÃ©n de las arenasâ??.\r\nJovellanos disfrutaba de frecuentes paseos por este litoral, asÃ­ que no es de extraÃ±ar que en 1780 se hiciera retratar en este mismo lugar por el pintor Goya, en un cuadro hoy expuesto en el museo de Bellas Artes de Asturias.\r\n', '¿Sabías que el nombre de la Escaleronase debe a su monumentalidad, pues cuenta con 75 peldaños de acceso a la playa, además de un pilar con termómetro, barómetro, medidor de marea, 3 relojes cuadrados y un mástil donde ondea la bandera de Gijón?\nâ?¦ en 1798, siendo Jovellanos Ministro de Gracia y Justicia, Goya vuelve a pintar a Jovellanos, esta vez apoyado en su mesa de trabajo y en actitud pensativa; y que dicho cuadro se expone en el Museo del Prado, en Madrid?\n', ' ¿Cómo se llama la playa de la ciudad natal de Jovellanos en la que el Ilustrado fue retratado por el pintor Goya?', '2018-05-15(11:00:02)-Jovellanos san Lorenzo.jpg', '2018-05-15(11:00:02)-Escalerona. Playa San Lorenzo. Gijón. Asturias.mp3', 36),
(44, 'Casona de Jovellanos ', 2, ' Plaza Jovellanos, 33201, GijÃ³n (Asturias)', 43.5458, -5.6626, 'La Casona de Jovellanos es en la actualidad una sidrerÃ­a y un hotel, anteriormente fue una vivienda conocida como â??La Casa del Fornoâ??, propiedad de la familia Jovellanos. \r\nEntre 1668 y 1679 se establecieron aquÃ­, de forma provisional, las monjas Agustinas Recoletas mientras finalizaba la construcciÃ³n de su convento (fundado en 1670) que estaba ubicado en una zona muy cercana. Dicho convento pasÃ³ a ser la FÃ¡brica de Tabacos de GijÃ³n tras la desamortizaciÃ³n. \r\nLa Casona de Jovellanos fue la primera sede del Real Instituto Asturiano de NÃ¡utica y MineralogÃ­a fundado por Jovellanos en 1794 gracias a que su hermano mayor, Don Francisco de Paula Jovellanos, le cediÃ³ la propiedad; siendo Ã©ste, ademÃ¡s, el primer Director del instituto.\r\n', 'Â¿SabÃ­as que....\r\n...se fundÃ³ este instituto dedicado a la nÃ¡utica y la minerÃ­a, pues era lo que mÃ¡s salida tenÃ­a en aquel entonces en Asturias?\r\n\r\n...en el subsuelo de la sidrerÃ­a que ocupa la planta baja pueden verse los cimientos de las primitivas murallas de la vieja ciudad?\r\n', '.', '2018-05-16(02:19:37)-plazuela.JPG', '2018-05-16(02:19:37)-45 sg.mp4', 36),
(45, 'Jardines del Naútico ', 3, 'Paseo del Muro de San Lorenzo, 33202, GijÃ³n', 43.5422, -5.6599, 'Los jardines estÃ¡n situados en una explanada triangular, al lado de la playa y frente a la Escalerona, y son el resultado de la demoliciÃ³n en el aÃ±o 1936 del Hospital de la Caridad, un cuartel, escuelas y otras edificaciones de la manzana, con motivo del Plan de Mejoras del Ayuntamiento para solucionar los problemas de trÃ¡fico e higiene que presentaba la ciudad. Sin embargo, hubo que esperar hasta despuÃ©s de la Guerra Civil para su construcciÃ³n. \r\nSe trazaron los jardines y se edificÃ³ un bar con forma de faro y motivos marineros. En 1975 se derruyÃ³ y en los aÃ±os 90, con motivo de la remodelaciÃ³n del muro de San Lorenzo que incluyÃ³ el diseÃ±o de estos jardines, se dio a este espacio la estÃ©tica que podemos ver hoy dÃ­a.\r\n', '	sabÃ­as queâ?¦\r\n\r\nâ?¦ el antiguo Hospital de la Caridad se instalÃ³ en 1835 en el solar que hoy ocupan los Jardines del NÃ¡utico y tuvo que hacer frente a epidÃ©micas de cÃ³lera, viruela o la terrible â??gripe espaÃ±olaâ?? de 1918, asÃ­ como acoger a los heridos de las guerras carlistas primero, y de la Guerra Civil despuÃ©s?\r\n\r\nâ?¦la Ã©poca dorada de los Jardines del NÃ¡utico fue entre los aÃ±os 1960-1964,  pues aquÃ­ se celebrÃ³ durante cuatro ediciones el Festival MelodÃ­a de la Costa Verde, con la presencia de artistas muy conocidos de la Ã©poca como Los Sonor, MiKe RÃ­os, Los Tres de Castilla, Luisa Linares y los Galindos o el DÃºo DinÃ¡mico?\r\n', ',', '2018-05-16(02:31:31)-Nautico 7.jpg', '2018-05-16(02:31:31)-45 sg.mp4', 36),
(47, 'Plaza del Parchis ', 5, 'Plaza del Instituto, 33201 GijÃ³n (Principado de Asturias)', 43.5413, -5.6613, 'El Real Instituto Asturiano de NÃ¡utica y MineralogÃ­a, gran obra docente de Melchor Gaspar de Jovellanos, tuvo inicialmente su sede en el barrio de Cimadevilla y luego se trasladÃ³ a este edificio situado en la Plaza del ParchÃ­s comenzado  en 1797 y terminado un siglo despuÃ©s. \r\nEl Real Instituto Asturiano de NÃ¡utica y MineralogÃ­a, gran obra docente de Melchor Gaspar de Jovellanos, tuvo inicialmente su sede en el barrio de Cimadevilla y luego se trasladÃ³ a este edificio situado en la Plaza del ParchÃ­s comenzado  en 1797 y terminado un siglo despuÃ©s. \r\nA oriente del Instituto, se habilitÃ³ esta plaza que ha tenido varios nombres oficiales: Plaza del GeneralÃ­simo, Plaza al Oriente de la Escuela Especial o Plaza de La Estacada, entre otros. El nombre oficial en la actualidad es Plaza del Instituto, pero este es poco conocido ya que en los aÃ±os cuarenta fue remodelada y pasÃ³ a ser conocida popularmente como Plaza del ParchÃ­s. Rodean a esta plaza una serie de edificios de notable interÃ©s como  la Casa Berenguer, de clara influencia modernista catalana; el Instituto Jovellanos o la BasÃ­lica del Sagrado CorazÃ³n de JesÃºs, conocida como â??La Iglesionaâ??.\r\n\r\n', 'â?¢	sabÃ­as queâ?¦\r\n\r\n...La Plaza del ParchÃ­s debe su nombre a que en el siglo XX tenÃ­a un diseÃ±o de baldosas y jardines que recordaban al tablero de este juego tan famoso?\r\n\r\n...En esta Ã©poca existÃ­a una lÃ­nea de tranvÃ­a que pasaba por la playa  y otros emplazamientos de la ciudad, entre ellos la Plaza del ParchÃ­s?\r\n\r\n', '.', '2018-05-16(03:23:59)-plaza del parchis .png', '2018-05-16(03:23:59)-45 sg.mp4', 36),
(48, 'Plaza del 6 de Agosto ', 6, 'Plaza Seis Agosto, 33206 Gijón (Principado de Asturias)', 43.5394, -5.6636, 'Por sus desavenencias con Godoy, en 1802 Jovellanos es encarcelado en el castillo de Bellver (Mallorca), donde pasó 6 años de su vida. Actualmente, este edificio está ocupado por el Museo de Historia de Palma de Mallorca.\r\nEn 1891, el escultor Manuel Fuxá levantó un monumento a Jovellanos para conmemorar el regreso del ilustrado a su ciudad natal el seis de agosto de 1811; monumento que hoy preside la plaza. Esta plaza era la punta de lanza de la calle Corrida, la cual unía el puerto carbonero de Gijón con la Puerta de la Villa, también construida en 1782 a instancias de Jovellanos y principal vía de comunicación con Oviedo hasta el siglo XX.\r\nEn esta plaza se levantan edificios de diferentes periodos que manifiestan la evolución de la ciudad como el Mercado del Sur, ejemplo de arquitectura del hierro, así como el edificio de Correos, de estilo regionalista.\r\n', '•	sabías que…\r\n\r\n... antes de ser trasladado al castillo de Bellver, Jovellanos estuvo también preso en la Real Cartuja de Valldemosa, en la misma isla de Mallorca?\r\n\r\n... Existe en la ciudad de Oviedo otro monumento conmemorativo a Jovellanos, en la calle que lleva su nombre, el cual fue proyectado por Juan de Villanueva, el mismo arquitecto que diseñó el Museo del Prado.\r\n', 'ok', '2018-05-16(03:26:17)-pl 6 agosto.jpg', '2018-05-16(03:26:17)-45 sg.mp4', 36),
(49, 'Calle Corrida', 7, 'Calle Corrida, 33206 GijÃ³n (Principado de Asturias)', 43.5418, -5.664, 'Desde la plaza del 6 de agosto entramos en la calle Corrida que actualmente tiene fines comerciales. \r\nEl Ensanche de Jovellanos comenzado en el siglo XVIII suponÃ­a la ampliaciÃ³n de la calle Corrida como entrada mÃ¡s directa a la ciudad de GijÃ³n a travÃ©s de la Puerta de la Villa o del Infante, y la calle de los Moros y Fuente Vieja. Uniendo de este modo, la carretera de Castilla y de Oviedo con la ciudad de GijÃ³n. \r\nLa calle Corrida, anteriormente â??Ancha de la Cruzâ??, debe su nombre a lo transitada o â??corridaâ?? que era; aunque tambiÃ©n hay otra teorÃ­a que lo relaciona con el corrimiento de una hilera de edificios,  que hicieron mÃ¡s ancha la calle. \r\nSe diseÃ±Ã³ como un tÃ­pico boulevard al estilo parisino, con farolas, arbolado, reloj y cafÃ©s; y en Ã©l apreciamos tambiÃ©n edificaciones de estilo Art Nouveau\r\n', 'Â¿Sabias que...\r\nqueâ?¦\r\n\r\n... antes de ser trasladado al castillo de Bellver, Jovellanos estuvo tambiÃ©n preso en la Real Cartuja de Valldemosa, en la misma isla de Mallorca?\r\n\r\n... Existe en la ciudad de Oviedo otro monumento conmemorativo a Jovellanos, en la calle que lleva su nombre, el cual fue proyectado por Juan de Villanueva, el mismo arquitecto que diseÃ±Ã³ el Museo del Prado.\r\n', '.', '2018-05-16(03:43:27)-calle corrida.jpg', '2018-05-16(03:43:27)-45 sg.mp4', 36),
(50, 'Jardines de la Reina ', 8, 'Calle MarquÃ©s de San Esteban, 1, 33201 GijÃ³n, Asturias', 43.5436, -5.6645, 'Desde la calle Corrida llegamos a los Jardines de la Reina, bautizados asÃ­ con motivo de la visita de la reina regente MarÃ­a Cristina de Habsburgo y su hijo el rey Alfonso XIII a la villa de GijÃ³n en 1900, durante la que se alojaron en el Palacio de Revillagigedo, frente a la Plaza del MarquÃ©s.\r\nDesde aquÃ­ podemos ver el antiguo Muelle (hoy Puerto Deportivo) al que llegaba el carbÃ³n de las cuencas mineras a travÃ©s de la carretera Carbonera y el ferrocarril de Langreo. Como consecuencia del desarrollo industrial creciÃ³ tanto la actividad del puerto local, que fue necesario construir otro, localizado hacia el exterior, que permitiera el atraque de embarcaciones de mayor calado: El Musel. Jovellanos ya habÃ­a propuesto la ampliaciÃ³n del puerto para poder comerciar con las Indias y luchÃ³ para que GijÃ³n ostentase la CapitanÃ­a MarÃ­tima Asturiana.\r\n', 'SABÃ?AS QUÃ? â?¦.\r\n...en la plaza del MarquÃ©s hay un pozo conocido como â??Pozo de la Barqueraâ?? que hoy pasa casi desapercibido, pero que tuvo una gran importancia entre los siglos XVI y XVIII pues desde esta ubicaciÃ³n se hacÃ­a pÃºblica la elecciÃ³n de los cargos polÃ­ticos del concejo de GijÃ³n?\r\nâ?¦ En el verano de 1858, la reina Isabel II puso de moda â??los baÃ±os de olaâ?? en la playa del Pando de la ciudad de GijÃ³n, una pequeÃ±a ensenada junto al puerto pesquero,  ya que por aquel entonces, la playa de San Lorenzo era considerada muy peligrosa por sus corrientes? AdemÃ¡s, en ese momento GijÃ³n ya contaba con servicio de casetas, pero hasta 1874 no se instalaron los primeros balnearios, llegando a contar con varios de ellos dentro de la propia ciudad\r\n', '.', '2018-05-16(03:48:08)-jardin reina .jpg', '2018-05-16(03:48:08)-45 sg.mp4', 36),
(51, 'Capilla de los Remedios ', 9, 'Calle los Remedios, 2D, 33201 GijÃ³n, Asturias', 43.5459, -5.6629, 'Pegada a la Casa Natal de Jovellanos se ubica la Capilla de los Remedios donde estÃ¡n los restos de Jovellanos, quien fue inhumado en el cementerio de Puerto de Vega (Navia) donde falleciÃ³ cuando regresaba a Asturias tras las invasiones napoleÃ³nicas en 1811. En 1815 su cuerpo es traÃ­do a GijÃ³n y se depositan sus restos en la Iglesia de San Pedro hasta que, en 1940, se trasladan definitivamente a esta Capilla. \r\nLa Capilla de Los Remedios se construyÃ³ en 1600 y su fachada fue remodelada en 1950\r\n', 'sabÃ­as queâ?¦\r\n\r\n... antes de ser trasladado al castillo de Bellver, Jovellanos estuvo tambiÃ©n preso en la Real Cartuja de Valldemosa, en la misma isla de Mallorca?\r\n\r\n... Existe en la ciudad de Oviedo otro monumento conmemorativo a Jovellanos, en la calle que lleva su nombre, el cual fue proyectado por Juan de Villanueva, el mismo arquitecto que diseÃ±Ã³ el Museo del Prado.\r\n', '.', '2018-05-16(03:51:03)-capilla de los remedios .png', '2018-05-16(03:51:03)-45 sg.mp4', 36);

-- --------------------------------------------------------

--
-- Table structure for table `premio`
--

CREATE TABLE `premio` (
  `idpremio` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `imagen` varchar(45) DEFAULT NULL,
  `fechaactivacion` date DEFAULT NULL,
  `fechaconsumo` date DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL,
  `cliente_idcliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `premio`
--

INSERT INTO `premio` (`idpremio`, `nombre`, `descripcion`, `imagen`, `fechaactivacion`, `fechaconsumo`, `puntos`, `cliente_idcliente`) VALUES
(1, 'Premio1', 'Premiando el esfuerzo', '2018-05-08(06:15:22)-ok.jpg', '2018-05-17', '2018-05-18', 123, 29);

-- --------------------------------------------------------

--
-- Table structure for table `pruebaCultural`
--

CREATE TABLE `pruebaCultural` (
  `idpruebacultural` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `pregunta` varchar(200) DEFAULT NULL,
  `respuesta` varchar(45) DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL,
  `parada_idparada` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pruebaCultural`
--

INSERT INTO `pruebaCultural` (`idpruebacultural`, `nombre`, `pregunta`, `respuesta`, `puntos`, `parada_idparada`) VALUES
(2, 'Habitantes', '¿Cuántos habitantes tienes Avilés aproximadamente?', 'Unos 83.000 habitantes\r\n', 90, 36);

-- --------------------------------------------------------

--
-- Table structure for table `pruebaDeportiva`
--

CREATE TABLE `pruebaDeportiva` (
  `idpruebadeportiva` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `fechainicio` date DEFAULT NULL,
  `fechafin` date DEFAULT NULL,
  `explicacion` text,
  `puntos` int(11) DEFAULT NULL,
  `parada_idparada` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pruebaDeportiva`
--

INSERT INTO `pruebaDeportiva` (`idpruebadeportiva`, `nombre`, `fechainicio`, `fechafin`, `explicacion`, `puntos`, `parada_idparada`) VALUES
(11, 'EL TEJUELO', '2018-01-17', '2018-01-17', 'El tejuelo, también denominado tejo, chito o tanga según la región, es un juego de precisión recogido por Jovellanos en su obra. “Memoria sobre la policía de los espectáculos y diversión pública en España (1790). Para superar el primer reto debes construir tu propio tejuelo usando una piedra o pelota, una botella, una moneda y una baldosa de campo de juego. ¡Afina tu puntería y gana el reto!. Deberás lanzar la piedra para derribar el tejuelo y que la moneda caiga dentro de la baldosa! ¡Ánimo!!! ', 1, 41),
(14, 'FLASHMOB', '2018-01-17', '2018-01-17', ' Los Jardines del Naútico son el escenario ideal para la tercera prueba: “Flashmob”, o ¿tienes vergüenza?. Pon a tope la música de tu móvil y crea tu coreografía y que se vayan uniendo!. ¡Quizás se anime algún paseante más!, graba tu actuación y sube el vídeo.', 1, 45),
(15, 'CORCHO BOLO', '2018-01-17', '2018-01-17', 'El antiguo Instituto de Naútica y Minerología alberga actualmente una sidrería que te permitirá abordar el segundo reto también de precisión, imitando los famosos juegos de bolos. Recoge corchos de botellas de sidra (mínimo 6) y forma una figura en altura, sepárate unos pasos y trata de derribar la figura!.  Graba tu partida y sube el vídeo!', 1, 44);

-- --------------------------------------------------------

--
-- Table structure for table `rol`
--

CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rol`
--

INSERT INTO `rol` (`idrol`, `nombre`) VALUES
(1, 'Administrador'),
(2, 'Turismo'),
(3, 'Actividades'),
(4, 'Registrado'),
(5, 'Anonimo');

-- --------------------------------------------------------

--
-- Table structure for table `voto`
--

CREATE TABLE `voto` (
  `idvoto` int(11) NOT NULL,
  `puntos` int(11) DEFAULT NULL,
  `cliente_idcliente` int(11) NOT NULL,
  `multimedia_idmultimedia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`idactividad`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`),
  ADD KEY `fk_cliente_rol1_idx` (`rol_idrol`);

--
-- Indexes for table `cliente_has_actividad`
--
ALTER TABLE `cliente_has_actividad`
  ADD PRIMARY KEY (`cliente_idcliente`,`actividad_idactividad`),
  ADD KEY `fk_cliente_has_actividad_actividad1_idx` (`actividad_idactividad`),
  ADD KEY `fk_cliente_has_actividad_cliente1_idx` (`cliente_idcliente`);

--
-- Indexes for table `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`idcomentario`),
  ADD KEY `fk_comentario_cliente1_idx` (`cliente_idcliente`),
  ADD KEY `fk_comentario_multimedia1_idx` (`multimedia_idmultimedia`);

--
-- Indexes for table `itinerario`
--
ALTER TABLE `itinerario`
  ADD PRIMARY KEY (`iditinerario`);

--
-- Indexes for table `multimedia`
--
ALTER TABLE `multimedia`
  ADD PRIMARY KEY (`idmultimedia`),
  ADD KEY `fk_multimedia_cliente1_idx` (`cliente_idcliente`),
  ADD KEY `fk_multimedia_pruebaDeportiva1_idx` (`pruebaDeportiva_idpruebadeportiva`);

--
-- Indexes for table `noticia`
--
ALTER TABLE `noticia`
  ADD PRIMARY KEY (`idnoticia`);

--
-- Indexes for table `parada`
--
ALTER TABLE `parada`
  ADD PRIMARY KEY (`idparada`),
  ADD KEY `fk_parada_itinerario_idx` (`itinerario_iditinerario`);

--
-- Indexes for table `premio`
--
ALTER TABLE `premio`
  ADD PRIMARY KEY (`idpremio`),
  ADD KEY `fk_premio_cliente1_idx` (`cliente_idcliente`);

--
-- Indexes for table `pruebaCultural`
--
ALTER TABLE `pruebaCultural`
  ADD PRIMARY KEY (`idpruebacultural`),
  ADD KEY `fk_pruebaCultural_parada1_idx` (`parada_idparada`);

--
-- Indexes for table `pruebaDeportiva`
--
ALTER TABLE `pruebaDeportiva`
  ADD PRIMARY KEY (`idpruebadeportiva`),
  ADD KEY `fk_pruebaDeportiva_parada1_idx` (`parada_idparada`);

--
-- Indexes for table `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idrol`);

--
-- Indexes for table `voto`
--
ALTER TABLE `voto`
  ADD PRIMARY KEY (`idvoto`),
  ADD KEY `fk_voto_cliente1_idx` (`cliente_idcliente`),
  ADD KEY `fk_voto_multimedia1_idx` (`multimedia_idmultimedia`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `actividad`
--
ALTER TABLE `actividad`
  MODIFY `idactividad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT for table `comentario`
--
ALTER TABLE `comentario`
  MODIFY `idcomentario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `itinerario`
--
ALTER TABLE `itinerario`
  MODIFY `iditinerario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT for table `multimedia`
--
ALTER TABLE `multimedia`
  MODIFY `idmultimedia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `noticia`
--
ALTER TABLE `noticia`
  MODIFY `idnoticia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `parada`
--
ALTER TABLE `parada`
  MODIFY `idparada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
--
-- AUTO_INCREMENT for table `premio`
--
ALTER TABLE `premio`
  MODIFY `idpremio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `pruebaCultural`
--
ALTER TABLE `pruebaCultural`
  MODIFY `idpruebacultural` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pruebaDeportiva`
--
ALTER TABLE `pruebaDeportiva`
  MODIFY `idpruebadeportiva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `rol`
--
ALTER TABLE `rol`
  MODIFY `idrol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `voto`
--
ALTER TABLE `voto`
  MODIFY `idvoto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_rol1` FOREIGN KEY (`rol_idrol`) REFERENCES `rol` (`idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `cliente_has_actividad`
--
ALTER TABLE `cliente_has_actividad`
  ADD CONSTRAINT `fk_cliente_has_actividad_actividad1` FOREIGN KEY (`actividad_idactividad`) REFERENCES `actividad` (`idactividad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cliente_has_actividad_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `fk_comentario_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_comentario_multimedia1` FOREIGN KEY (`multimedia_idmultimedia`) REFERENCES `multimedia` (`idmultimedia`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `multimedia`
--
ALTER TABLE `multimedia`
  ADD CONSTRAINT `fk_multimedia_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_multimedia_pruebaDeportiva1` FOREIGN KEY (`pruebaDeportiva_idpruebadeportiva`) REFERENCES `pruebaDeportiva` (`idpruebadeportiva`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `parada`
--
ALTER TABLE `parada`
  ADD CONSTRAINT `fk_parada_itinerario` FOREIGN KEY (`itinerario_iditinerario`) REFERENCES `itinerario` (`iditinerario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `premio`
--
ALTER TABLE `premio`
  ADD CONSTRAINT `fk_premio_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pruebaCultural`
--
ALTER TABLE `pruebaCultural`
  ADD CONSTRAINT `fk_pruebaCultural_parada1` FOREIGN KEY (`parada_idparada`) REFERENCES `parada` (`idparada`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pruebaDeportiva`
--
ALTER TABLE `pruebaDeportiva`
  ADD CONSTRAINT `fk_pruebaDeportiva_parada1` FOREIGN KEY (`parada_idparada`) REFERENCES `parada` (`idparada`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `voto`
--
ALTER TABLE `voto`
  ADD CONSTRAINT `fk_voto_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_voto_multimedia1` FOREIGN KEY (`multimedia_idmultimedia`) REFERENCES `multimedia` (`idmultimedia`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Hoszt: localhost
-- Létrehozás ideje: 2025. Már 21. 08:54
-- Szerver verzió: 5.6.20-log
-- PHP verzió: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Adatbázis: `ingatlan`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `ingatlanok`
--

CREATE TABLE IF NOT EXISTS `ingatlanok` (
  `id` int(11) NOT NULL,
  `kategoria` int(11) NOT NULL,
  `leiras` text COLLATE utf8_hungarian_ci,
  `hirdetesDatuma` date DEFAULT NULL,
  `tehermentes` tinyint(1) NOT NULL,
  `ar` int(11) NOT NULL,
  `kepUrl` text COLLATE utf8_hungarian_ci
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `ingatlanok`
--

INSERT INTO `ingatlanok` (`id`, `kategoria`, `leiras`, `hirdetesDatuma`, `tehermentes`, `ar`, `kepUrl`) VALUES
(1, 1, 'Kertvárosi részén, egyszintes házat kínálunk nyugodt környezetben, nagy telken.', '2022-02-21', 1, 26990000, 'http://localhost:3000/adv01.jpg'),
(2, 1, 'Belvárosi környezetben, árnyékos helyen kis méretú családi ház eladó. Tömegközlekedéssel könnyen megközelíthető.', '2022-02-28', 1, 28990000, 'http://localhost:3000/adv02.jpg'),
(3, 2, 'Kétszintes berendezett lakás a belvárosban kiadó.', '2022-02-24', 1, 32000000, 'http://localhost:3000/adv03.jpg'),
(4, 4, 'Nagy garázs kertvárosi környezetben kiadó', '2022-02-26', 1, 5990000, 'http://localhost:3000/adv04.jpg'),
(5, 5, '10 hektáros mezőhazdasági terület eladó.', '2022-03-18', 1, 79000000, 'http://localhost:3000/adv05.jpg'),
(6, 6, 'Felújításra szoruló üzemcsarnok zöld környezetben áron alul eladó', '2022-02-23', 0, 25000000, 'http://localhost:3000/adv06.jpg');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `kategoriak`
--

CREATE TABLE IF NOT EXISTS `kategoriak` (
`id` int(11) NOT NULL,
  `nev` varchar(50) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci AUTO_INCREMENT=7 ;

--
-- A tábla adatainak kiíratása `kategoriak`
--

INSERT INTO `kategoriak` (`id`, `nev`) VALUES
(1, 'Ház'),
(2, 'Lakás'),
(3, 'Építési telek'),
(4, 'Garázs'),
(5, 'Mezőgazdasági terület'),
(6, 'Ipari ingatlan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kategoriak`
--
ALTER TABLE `kategoriak`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `nev` (`nev`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kategoriak`
--
ALTER TABLE `kategoriak`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

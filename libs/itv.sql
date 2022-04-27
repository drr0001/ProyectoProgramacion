-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-04-2022 a las 13:12:54
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `itv`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `DNI` varchar(20) NOT NULL,
  `nombre` text NOT NULL,
  `ciudad` text NOT NULL,
  `direccion` varchar(20) NOT NULL,
  `telf` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`DNI`, `nombre`, `ciudad`, `direccion`, `telf`) VALUES
('14523678O', 'Alberto', 'Malaga', 'Avenida benitoCamela', 625314785),
('23665931P', 'Marta', 'Girona', 'Calle RosaMelano', 711453698),
('34585637F', 'Pedro', 'Malaga', 'centro', 645378293),
('35487645P', 'Carlos', 'Almeria', 'Calle GokuleGana 3º', 763254178),
('41244521Y', 'Roxana', 'Mayorca', 'Avenida Michel Salga', 461238975),
('49506470M', 'Rafa', 'Cordoba', 'Margaritas', 647993745),
('63846756G', 'Juan', 'Madrid', 'vallecas', 655347821),
('66535412T', 'Sofia', 'Albacete', 'Calle VodzkaJunior', 614523698),
('79462583D', 'Rafael', 'Cadiz', 'cCalle Javi aprueban', 654123789),
('96541238S', 'Miguel', 'Leon', 'Avenida OrtitoRico', 655423981);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coche`
--

CREATE TABLE `coche` (
  `matricula` varchar(20) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `color` varchar(20) NOT NULL,
  `precio` int(20) NOT NULL,
  `dni` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `coche`
--

INSERT INTO `coche` (`matricula`, `marca`, `modelo`, `color`, `precio`, `dni`) VALUES
('0078OPO', 'Mazda', '7', 'Verde', 6000, '96541238S'),
('123456CO', 'Seat', 'Leon', 'verde', 1000, '14523678O'),
('1234CBD', 'Porsche', 'cayenne', 'negro', 50000, '63846756G'),
('2345AFV', 'Ford', 'Mustang', 'Rojo', 30000, '35487645P'),
('4321FFF', 'ferrari', 'f1', 'rojo', 50000, '49506470M'),
('4321JBB', 'Mini', 'Cooper', 'blanco', 3000, '63846756G'),
('4325TTT', 'ford', 'fiesta', 'rojo', 150, '49506470M'),
('45631GGH', 'Ford', 'Focus', 'azul', 2500, '23665931P'),
('4658HKL', 'Mazda', '2', 'Gris', 1000, '79462583D'),
('5342TVD', 'Ford', 'Kuga', 'negro', 5000, '34585637F'),
('5639TFG', 'Jaguar', 'nomesemodelos', 'Negro', 7000, '66535412T'),
('7523ABC', 'Honda', 'g-12', 'Blanco', 1000, '35487645P'),
('7654RPG', 'Seat', 'Ibiza', 'Rojo', 2500, '34585637F'),
('8567LLP', 'Dodge', 'Mucaro', 'Negro', 25000, '41244521Y'),
('9461ZXF', 'Nissan', 'Cascai', 'Oro', 900, '23665931P'),
('9654QAP', 'Reanult', 'golf', 'Gris', 8000, '23665931P'),
('9876DNB', 'Honda', 'Civic', '9876DNB', 10000, '49506470M'),
('efefefg', 'gerg', 'rgergerg', 'regreg', 2333, '49506470M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revision`
--

CREATE TABLE `revision` (
  `codigo` int(20) NOT NULL,
  `matricula` varchar(20) NOT NULL,
  `filtro` tinyint(1) NOT NULL,
  `aceite` tinyint(1) NOT NULL,
  `frenos` tinyint(1) NOT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `revision`
--

INSERT INTO `revision` (`codigo`, `matricula`, `filtro`, `aceite`, `frenos`, `fecha`) VALUES
(9, '4321JBB', 0, 1, 1, '2022-04-22'),
(7, '5342TVD', 0, 1, 0, '2021-10-07'),
(4, 'efefefg', 1, 1, 1, '2022-02-20'),
(3, '9876DNB', 1, 0, 1, '2020-06-21'),
(2, '9654QAP ', 1, 1, 1, '2020-11-08'),
(1, '9461ZXF  ', 0, 1, 1, '2021-12-08'),
(5, '8567LLP   ', 0, 1, 0, '2021-09-12'),
(6, '7654RPG    ', 1, 1, 1, '2020-08-08'),
(8, '7523ABC     ', 1, 1, 1, '2021-11-06'),
(10, '5639TFG', 1, 1, 1, '2020-12-01'),
(11, '4658HKL', 1, 0, 1, '2021-10-20'),
(12, '4325TTT ', 1, 0, 0, '2022-01-15'),
(13, '45631GGH ', 1, 1, 1, '2022-01-15'),
(14, '4321FFF ', 1, 1, 1, '2020-12-15'),
(15, '2345AFV  ', 1, 1, 1, '2020-12-15'),
(16, '1234CBD   ', 1, 1, 1, '2020-12-15'),
(17, '123456CO    ', 1, 1, 1, '2022-04-22'),
(18, '0078OPO', 1, 1, 1, '2022-03-15');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `coche`
--
ALTER TABLE `coche`
  ADD PRIMARY KEY (`matricula`),
  ADD KEY `dni` (`dni`);

--
-- Indices de la tabla `revision`
--
ALTER TABLE `revision`
  ADD KEY `matricula` (`matricula`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `coche`
--
ALTER TABLE `coche`
  ADD CONSTRAINT `coche_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `cliente` (`DNI`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `revision`
--
ALTER TABLE `revision`
  ADD CONSTRAINT `revision_ibfk_1` FOREIGN KEY (`matricula`) REFERENCES `coche` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 20, 2016 at 05:48 
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sysreserva`
--

-- --------------------------------------------------------

--
-- Table structure for table `aula`
--

CREATE TABLE `aula` (
  `idAula` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `duracao` int(10) DEFAULT NULL,
  `idSiape` int(11) NOT NULL,
  `idSala` int(11) NOT NULL,
  `idItemEquipamento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aula`
--

INSERT INTO `aula` (`idAula`, `data`, `hora`, `duracao`, `idSiape`, `idSala`, `idItemEquipamento`) VALUES
(3, '2016-10-18', '22:12:15', 34, 123, 1, 1),
(5, '2016-10-18', '22:13:18', 80, 123, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `equipamento`
--

CREATE TABLE `equipamento` (
  `idEquipamento` int(11) NOT NULL,
  `nomeEquipamento` varchar(45) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `utilidade` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipamento`
--

INSERT INTO `equipamento` (`idEquipamento`, `nomeEquipamento`, `marca`, `tipo`, `utilidade`) VALUES
(1, 'Data Show2', 'HP', 'Projetor', 'teste'),
(3, 'Caixa de Som', 'Sony', 'Som', 'aula'),
(4, 'Caixa de Som', 'Sony', 'Som', 'aula');

-- --------------------------------------------------------

--
-- Table structure for table `itemEquipamento`
--

CREATE TABLE `itemEquipamento` (
  `idItemEquipamento` int(11) NOT NULL,
  `quantidadeUsada` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemEquipamento`
--

INSERT INTO `itemEquipamento` (`idItemEquipamento`, `quantidadeUsada`) VALUES
(1, 10),
(3, 12);

-- --------------------------------------------------------

--
-- Table structure for table `professor`
--

CREATE TABLE `professor` (
  `SIAPE` int(11) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Senha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `professor`
--

INSERT INTO `professor` (`SIAPE`, `Nome`, `Senha`) VALUES
(123, 'Fulano', '123456'),
(125, 'teste', '12321'),
(146, 'teste', '12321'),
(184, 'teste', '12321');

-- --------------------------------------------------------

--
-- Table structure for table `sala`
--

CREATE TABLE `sala` (
  `idSala` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `localizacao` varchar(45) DEFAULT NULL,
  `capacidade` int(10) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sala`
--

INSERT INTO `sala` (`idSala`, `nome`, `localizacao`, `capacidade`, `tipo`) VALUES
(1, 'Biologia', 'C2', 40, 'teste'),
(3, 'Física', 'B2', 45, 'Laboratóri'),
(4, 'PortuguÃªs', 'D1', 40, 'sala'),
(5, 'PortuguÃªs', 'D1', 40, 'sala'),
(6, 'fdfd', 'fdfd', 23, 'dsds'),
(7, 'gfg', 'fgs', 43, 'werew'),
(8, 'rerer', 'rer', 44, 'fdfd'),
(9, 'fdfds', 'sssss', 22, 're'),
(10, 'fdfds', 'sssss', 22, 're'),
(11, 'nome', 'nome', 12, 'nome'),
(12, 'eee', 'eee', 43, 'rr'),
(13, 'tt', 'rr', 32, '4rr'),
(14, 'teste', 'teste', 44, 'teste'),
(15, 'rrrr', 'rrrr', 33, 'rrrr'),
(16, 'tttt', 'ttttt', 11, 'ttt');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`idAula`),
  ADD KEY `fk1_idx` (`idSiape`),
  ADD KEY `fk2_idx` (`idSala`),
  ADD KEY `fk3_idx` (`idItemEquipamento`);

--
-- Indexes for table `equipamento`
--
ALTER TABLE `equipamento`
  ADD PRIMARY KEY (`idEquipamento`);

--
-- Indexes for table `itemEquipamento`
--
ALTER TABLE `itemEquipamento`
  ADD KEY `fj_idx` (`idItemEquipamento`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`SIAPE`);

--
-- Indexes for table `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`idSala`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aula`
--
ALTER TABLE `aula`
  MODIFY `idAula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `equipamento`
--
ALTER TABLE `equipamento`
  MODIFY `idEquipamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `sala`
--
ALTER TABLE `sala`
  MODIFY `idSala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `aula`
--
ALTER TABLE `aula`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`idSIAPE`) REFERENCES `professor` (`SIAPE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk2` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk3` FOREIGN KEY (`idItemEquipamento`) REFERENCES `itemEquipamento` (`idItemEquipamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `itemEquipamento`
--
ALTER TABLE `itemEquipamento`
  ADD CONSTRAINT `fk` FOREIGN KEY (`idItemEquipamento`) REFERENCES `equipamento` (`idEquipamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

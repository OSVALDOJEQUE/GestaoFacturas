-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 12, 2019 at 12:25 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestao`
--

-- --------------------------------------------------------

--
-- Table structure for table `cargo`
--

CREATE TABLE `cargo` (
  `codCargo` int(11) NOT NULL,
  `cargo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `empresa`
--

CREATE TABLE `empresa` (
  `Nome` varchar(20) NOT NULL,
  `Cidade` varchar(15) DEFAULT NULL,
  `Nuit` int(11) NOT NULL,
  `Telefone` int(12) NOT NULL,
  `Email` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `fornecedor`
--

CREATE TABLE `fornecedor` (
  `codFornecedor` int(11) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Endereco` varchar(30) NOT NULL,
  `Telefone` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `fornecedor`
--

INSERT INTO `fornecedor` (`codFornecedor`, `Nome`, `Endereco`, `Telefone`) VALUES
(4, 'Jonatah', 'Jardim', 841234567),
(7, 'Nooqlear', 'Zimpeto', 84751),
(8, 'Limoce', 'Aeroporto', 841111258),
(9, 'Construa', 'Choupal', 841257),
(10, 'SHM', 'Malhazine', 8412345),
(14, 'Bar', 'Mafala', 85418),
(16, 'Banco', 'Museu', 84789),
(17, 'Baltazar', 'Central', 84221),
(18, 'FIPAG', 'Matola', 84215),
(20, 'Gawat', '25 de junho B', 84999),
(21, 'EDM', 'Jardim', 84125),
(22, 'Sombra Matsinhe', 'Choupal', 871245),
(23, 'Sao Valetim', 'Choupsl', 83879),
(24, 'Midorima', 'AV 24 de julho, Nr 1783', 838482);

-- --------------------------------------------------------

--
-- Table structure for table `produto`
--

CREATE TABLE `produto` (
  `CodProduto` int(11) NOT NULL,
  `Descr` varchar(20) NOT NULL,
  `Quantidade` int(11) DEFAULT NULL,
  `CodFornecedor` int(11) NOT NULL,
  `PrecoUnit` decimal(11,2) DEFAULT NULL,
  `CodTipoProduto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produto`
--

INSERT INTO `produto` (`CodProduto`, `Descr`, `Quantidade`, `CodFornecedor`, `PrecoUnit`, `CodTipoProduto`) VALUES
(3, 'Energia', 1, 21, '1500.00', 6),
(4, 'A4', 400, 4, '100.00', 8);

-- --------------------------------------------------------

--
-- Table structure for table `tipoproduto`
--

CREATE TABLE `tipoproduto` (
  `CodTipoProduto` int(11) NOT NULL,
  `DescrTipoProduto` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipoproduto`
--

INSERT INTO `tipoproduto` (`CodTipoProduto`, `DescrTipoProduto`) VALUES
(6, 'Recargas'),
(7, 'Toners'),
(8, 'Papel'),
(9, 'Ventilacao'),
(10, 'Barro'),
(11, 'Calhas'),
(12, 'Tinta');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `CodUsuario` int(11) NOT NULL,
  `nome` varchar(25) NOT NULL,
  `senha` varchar(16) NOT NULL,
  `Tipo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`CodUsuario`, `nome`, `senha`, `Tipo`) VALUES
(1, 'NOOQ', '12345', 'Administrador'),
(2, 'VAVA', '1234', 'Normal');

-- --------------------------------------------------------

--
-- Table structure for table `venda`
--

CREATE TABLE `venda` (
  `CodVenda` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `PrecoTotal` decimal(10,0) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `venda_produto`
--

CREATE TABLE `venda_produto` (
  `CodVenda` int(11) NOT NULL,
  `Codproduto` int(11) NOT NULL,
  `DataEmissao` datetime NOT NULL,
  `DataValidade` datetime NOT NULL,
  `quantidade` int(11) NOT NULL,
  `desconto` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`codCargo`);

--
-- Indexes for table `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`Nuit`),
  ADD UNIQUE KEY `Nuit` (`Nuit`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`codFornecedor`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`CodProduto`),
  ADD KEY `TipoProduto` (`CodTipoProduto`),
  ADD KEY `FornecidoPor` (`CodFornecedor`);

--
-- Indexes for table `tipoproduto`
--
ALTER TABLE `tipoproduto`
  ADD PRIMARY KEY (`CodTipoProduto`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`CodUsuario`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`CodVenda`);

--
-- Indexes for table `venda_produto`
--
ALTER TABLE `venda_produto`
  ADD PRIMARY KEY (`Codproduto`),
  ADD KEY `venda` (`CodVenda`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `codFornecedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `CodProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tipoproduto`
--
ALTER TABLE `tipoproduto`
  MODIFY `CodTipoProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `CodUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `CodVenda` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `FornecidoPor` FOREIGN KEY (`CodFornecedor`) REFERENCES `fornecedor` (`codFornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `TipoProduto` FOREIGN KEY (`CodTipoProduto`) REFERENCES `tipoproduto` (`CodTipoProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `venda_produto`
--
ALTER TABLE `venda_produto`
  ADD CONSTRAINT `Produto` FOREIGN KEY (`Codproduto`) REFERENCES `produto` (`CodProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `venda` FOREIGN KEY (`CodVenda`) REFERENCES `venda` (`CodVenda`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

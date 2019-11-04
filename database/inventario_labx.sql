SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventario_labx`
--

-- --------------------------------------------------------

--
-- Table structure for table `Auditoria`
--

CREATE TABLE `Auditoria` (
  `ID_AUDITORIA` bigint(255) UNSIGNED NOT NULL,
  `ID_USUARIO` bigint(255) UNSIGNED NOT NULL,
  `Accion` varchar(255) NOT NULL,
  `DataTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `Activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Auditoria`
--

INSERT INTO `Auditoria` (`ID_AUDITORIA`, `ID_USUARIO`, `Accion`, `DataTime`, `Activo`) VALUES
(1, 1, 'INGRESO', '2019-10-03 20:30:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Bodegas`
--

CREATE TABLE `Bodegas` (
  `ID_BODEGA` bigint(255) UNSIGNED NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Localizacion` varchar(255) NOT NULL,
  `ID_USUARIO` bigint(255) UNSIGNED NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Bodegas`
--

INSERT INTO `Bodegas` (`ID_BODEGA`, `Nombre`, `Localizacion`, `ID_USUARIO`, `Activo`) VALUES
(1, 'BODEGA PRINCIPAL', 'LABORATORIO PRINCIPAL', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Familias`
--

CREATE TABLE `Familias` (
  `ID_FAMILIA` bigint(255) UNSIGNED NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Familias`
--

INSERT INTO `Familias` (`ID_FAMILIA`, `Nombre`, `Activo`) VALUES
(1, 'SECCIÓN PRUEBA', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Informe`
--

CREATE TABLE `Informe` (
  `ID_PRODUCTO` bigint(255) UNSIGNED NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Marca` varchar(255) NOT NULL,
  `Proveedor` varchar(255) NOT NULL,
  `Codigo` varchar(15) NOT NULL,
  `Presentacion` varchar(100) NOT NULL,
  `RegINVIMA` varchar(15) NOT NULL,
  `ClasificacionRiesgo` varchar(10) NOT NULL,
  `TempAlmacenamiento` varchar(5) NOT NULL,
  `FechaVencimiento` date NOT NULL,
  `CantidadInventario` decimal(10,2) UNSIGNED NOT NULL,
  `ID_USUARIO` bigint(255) UNSIGNED NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Informe`
--

INSERT INTO `Informe` (`ID_PRODUCTO`, `Nombre`, `Marca`, `Proveedor`, `Codigo`, `Presentacion`, `RegINVIMA`, `ClasificacionRiesgo`, `TempAlmacenamiento`, `FechaVencimiento`, `CantidadInventario`, `ID_USUARIO`, `Activo`) VALUES
(1, 'PRODUCTO PRUEBA', 'MARCA PRUEBA', 'PROVEEDOR PRUEBA', '1000000001', '1x10L', '2011RD-0009999', 'II', '25-30', '2019-12-31', '10.00', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Inventario`
--

CREATE TABLE `Inventario` (
  `ID_PRODUCTO` bigint(255) UNSIGNED NOT NULL,
  `Lote` varchar(20) NOT NULL,
  `FechaVencimiento` date NOT NULL,
  `Cantidad` decimal(10,2) UNSIGNED NOT NULL,
  `CantidadAnterior` decimal(10,2) UNSIGNED NOT NULL,
  `ID_BODEGA` bigint(255) UNSIGNED NOT NULL,
  `ID_USUARIO` bigint(255) UNSIGNED NOT NULL,
  `ID_AUDITORIA` bigint(255) UNSIGNED NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Inventario`
--

INSERT INTO `Inventario` (`ID_PRODUCTO`, `Lote`, `FechaVencimiento`, `Cantidad`, `CantidadAnterior`, `ID_BODEGA`, `ID_USUARIO`, `ID_AUDITORIA`, `Activo`) VALUES
(1, '12345', '2019-12-31', '10.00', '0.00', 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Kardex`
--

CREATE TABLE `Kardex` (
  `ID_KARDEX` bigint(255) UNSIGNED NOT NULL,
  `ID_PRODUCTO` bigint(255) UNSIGNED NOT NULL,
  `Lote` varchar(20) NOT NULL,
  `FechaVencimiento` date NOT NULL,
  `Cantidad` decimal(10,2) UNSIGNED NOT NULL,
  `CantidadAnterior` decimal(10,2) UNSIGNED NOT NULL,
  `ID_BODEGA` bigint(255) UNSIGNED NOT NULL,
  `ID_USUARIO` bigint(255) UNSIGNED NOT NULL,
  `ID_AUDITORIA` bigint(255) UNSIGNED NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Kardex`
--

INSERT INTO `Kardex` (`ID_KARDEX`, `ID_PRODUCTO`, `Lote`, `FechaVencimiento`, `Cantidad`, `CantidadAnterior`, `ID_BODEGA`, `ID_USUARIO`, `ID_AUDITORIA`, `Activo`) VALUES
(1, 1, '12345', '2019-12-31', '10.00', '0.00', 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Producto`
--

CREATE TABLE `Producto` (
  `ID_PRODUCTO` bigint(255) UNSIGNED NOT NULL,
  `ID_FAMILIA` bigint(255) UNSIGNED NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Marca` varchar(255) NOT NULL,
  `Proveedor` varchar(255) NOT NULL,
  `Codigo` varchar(15) NOT NULL,
  `Presentacion` varchar(100) NOT NULL,
  `RegINVIMA` varchar(15) NOT NULL,
  `ClasificacionRiesgo` varchar(10) NOT NULL,
  `TempAlmacenamiento` varchar(5) NOT NULL,
  `ID_USUARIO` bigint(255) UNSIGNED NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Producto`
--

INSERT INTO `Producto` (`ID_PRODUCTO`, `ID_FAMILIA`, `Nombre`, `Marca`, `Proveedor`, `Codigo`, `Presentacion`, `RegINVIMA`, `ClasificacionRiesgo`, `TempAlmacenamiento`, `ID_USUARIO`, `Activo`) VALUES
(1, 1, 'PRODUCTO PRUEBA', 'MARCA PRUEBA', 'PROVEEDOR PRUEBA', '1000000001', '1x10L', '2011RD-0009999', 'II', '25-30', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Auditoria`
--
ALTER TABLE `Auditoria`
  ADD PRIMARY KEY (`ID_AUDITORIA`),
  ADD UNIQUE KEY `ID_AUDITORIA` (`ID_AUDITORIA`),
  ADD KEY `ID_AUDITORIA_2` (`ID_AUDITORIA`),
  ADD KEY `ID_USUARIO` (`ID_USUARIO`);

--
-- Indexes for table `Bodegas`
--
ALTER TABLE `Bodegas`
  ADD PRIMARY KEY (`ID_BODEGA`),
  ADD UNIQUE KEY `ID_BODEGA` (`ID_BODEGA`),
  ADD KEY `ID_BODEGA_2` (`ID_BODEGA`),
  ADD KEY `ID_USUARIO_BODEGAS` (`ID_USUARIO`);

--
-- Indexes for table `Familias`
--
ALTER TABLE `Familias`
  ADD PRIMARY KEY (`ID_FAMILIA`),
  ADD UNIQUE KEY `ID_FAMILIA` (`ID_FAMILIA`),
  ADD KEY `ID_FAMILIA_2` (`ID_FAMILIA`);

--
-- Indexes for table `Informe`
--
ALTER TABLE `Informe`
  ADD PRIMARY KEY (`ID_PRODUCTO`),
  ADD UNIQUE KEY `ID_PRODUCTO` (`ID_PRODUCTO`),
  ADD KEY `ID_PRODUCTO_2` (`ID_PRODUCTO`),
  ADD KEY `ID_USUARIO_INFORME` (`ID_USUARIO`);

--
-- Indexes for table `Inventario`
--
ALTER TABLE `Inventario`
  ADD PRIMARY KEY (`ID_PRODUCTO`),
  ADD UNIQUE KEY `ID_PRODUCTO` (`ID_PRODUCTO`),
  ADD KEY `ID_PRODUCTO_2` (`ID_PRODUCTO`),
  ADD KEY `ID_AUDITORIA_INVENTARIO` (`ID_AUDITORIA`),
  ADD KEY `ID_BODEGA_INVENTARIO` (`ID_BODEGA`),
  ADD KEY `ID_USUARIO_INVENTARIO` (`ID_USUARIO`);

--
-- Indexes for table `Kardex`
--
ALTER TABLE `Kardex`
  ADD PRIMARY KEY (`ID_KARDEX`),
  ADD UNIQUE KEY `ID_KARDEX` (`ID_KARDEX`),
  ADD KEY `ID_KARDEX_2` (`ID_KARDEX`),
  ADD KEY `ID_AUDITORIA_KARDEX` (`ID_AUDITORIA`),
  ADD KEY `ID_BODEGA_KARDEX` (`ID_BODEGA`),
  ADD KEY `ID_PRODUCTO_KARDEX` (`ID_PRODUCTO`),
  ADD KEY `ID_USUARIO_KARDEX` (`ID_USUARIO`);

--
-- Indexes for table `Producto`
--
ALTER TABLE `Producto`
  ADD PRIMARY KEY (`ID_PRODUCTO`),
  ADD UNIQUE KEY `ID_PRODUCTO` (`ID_PRODUCTO`),
  ADD KEY `ID_PRODUCTO_2` (`ID_PRODUCTO`),
  ADD KEY `ID_FAMILIA_PRODUCTO` (`ID_FAMILIA`),
  ADD KEY `ID_USUARIO_PRODUCTO` (`ID_USUARIO`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Auditoria`
--
ALTER TABLE `Auditoria`
  MODIFY `ID_AUDITORIA` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Bodegas`
--
ALTER TABLE `Bodegas`
  MODIFY `ID_BODEGA` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Familias`
--
ALTER TABLE `Familias`
  MODIFY `ID_FAMILIA` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Informe`
--
ALTER TABLE `Informe`
  MODIFY `ID_PRODUCTO` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Inventario`
--
ALTER TABLE `Inventario`
  MODIFY `ID_PRODUCTO` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Kardex`
--
ALTER TABLE `Kardex`
  MODIFY `ID_KARDEX` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Producto`
--
ALTER TABLE `Producto`
  MODIFY `ID_PRODUCTO` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Auditoria`
--
ALTER TABLE `Auditoria`
  ADD CONSTRAINT `ID_USUARIO_AUDITORIA` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios_labx`.`Usuarios` (`ID_USUARIO`);

--
-- Constraints for table `Bodegas`
--
ALTER TABLE `Bodegas`
  ADD CONSTRAINT `ID_USUARIO_BODEGAS` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios_labx`.`Usuarios` (`ID_USUARIO`);

--
-- Constraints for table `Informe`
--
ALTER TABLE `Informe`
  ADD CONSTRAINT `ID_PRODUCTO_INFORME` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `Informe` (`ID_PRODUCTO`),
  ADD CONSTRAINT `ID_USUARIO_INFORME` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios_labx`.`Usuarios` (`ID_USUARIO`);

--
-- Constraints for table `Inventario`
--
ALTER TABLE `Inventario`
  ADD CONSTRAINT `ID_AUDITORIA_INVENTARIO` FOREIGN KEY (`ID_AUDITORIA`) REFERENCES `Auditoria` (`ID_AUDITORIA`),
  ADD CONSTRAINT `ID_BODEGA_INVENTARIO` FOREIGN KEY (`ID_BODEGA`) REFERENCES `Bodegas` (`ID_BODEGA`),
  ADD CONSTRAINT `ID_PRODUCTO_INVENTARIO` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `Producto` (`ID_PRODUCTO`),
  ADD CONSTRAINT `ID_USUARIO_INVENTARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios_labx`.`Usuarios` (`ID_USUARIO`);

--
-- Constraints for table `Kardex`
--
ALTER TABLE `Kardex`
  ADD CONSTRAINT `ID_AUDITORIA_KARDEX` FOREIGN KEY (`ID_AUDITORIA`) REFERENCES `Auditoria` (`ID_AUDITORIA`),
  ADD CONSTRAINT `ID_BODEGA_KARDEX` FOREIGN KEY (`ID_BODEGA`) REFERENCES `Bodegas` (`ID_BODEGA`),
  ADD CONSTRAINT `ID_PRODUCTO_KARDEX` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `Producto` (`ID_PRODUCTO`),
  ADD CONSTRAINT `ID_USUARIO_KARDEX` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios_labx`.`Usuarios` (`ID_USUARIO`);

--
-- Constraints for table `Producto`
--
ALTER TABLE `Producto`
  ADD CONSTRAINT `ID_FAMILIA_PRODUCTO` FOREIGN KEY (`ID_FAMILIA`) REFERENCES `Familias` (`ID_FAMILIA`),
  ADD CONSTRAINT `ID_USUARIO_PRODUCTO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios_labx`.`Usuarios` (`ID_USUARIO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

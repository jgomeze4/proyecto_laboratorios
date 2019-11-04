SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `usuarios_labx`
--

-- --------------------------------------------------------

--
-- Table structure for table `Auditoria`
--

CREATE TABLE `Auditoria` (
  `ID_AUDITORIA_USUARIOS` bigint(255) NOT NULL,
  `ID_USUARIO` bigint(255) UNSIGNED NOT NULL,
  `Accion` varchar(255) NOT NULL,
  `DateTime` datetime NOT NULL DEFAULT current_timestamp(),
  `Activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Auditoria`
--

INSERT INTO `Auditoria` (`ID_AUDITORIA_USUARIOS`, `ID_USUARIO`, `Accion`, `DateTime`, `Activo`) VALUES
(1, 1, 'INGRESO', '2019-11-03 17:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Roles`
--

CREATE TABLE `Roles` (
  `ID_ROL` bigint(255) UNSIGNED NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Permisos` varchar(255) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Roles`
--

INSERT INTO `Roles` (`ID_ROL`, `Nombre`, `Permisos`, `Activo`) VALUES
(1, 'ROL PRUEBA', '1,2,3', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Usuarios`
--

CREATE TABLE `Usuarios` (
  `ID_USUARIO` bigint(255) UNSIGNED NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Contrasena` varchar(100) NOT NULL,
  `Token` varchar(255) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Cliente` varchar(255) NOT NULL,
  `ID_ROL` bigint(255) UNSIGNED NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Usuarios`
--

INSERT INTO `Usuarios` (`ID_USUARIO`, `Nombre`, `Contrasena`, `Token`, `Email`, `Cliente`, `ID_ROL`, `Activo`) VALUES
(1, 'USUARIO PRUEBA', '12345', '1a2b3c4d5f', 'prueba@eafit.edu.co', 'EAFIT', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Auditoria`
--
ALTER TABLE `Auditoria`
  ADD PRIMARY KEY (`ID_AUDITORIA_USUARIOS`),
  ADD UNIQUE KEY `ID_AUDITORIA_USUARIOS` (`ID_AUDITORIA_USUARIOS`),
  ADD KEY `ID_AUDITORIA_USUARIOS_2` (`ID_AUDITORIA_USUARIOS`),
  ADD KEY `ID_USUARIO` (`ID_USUARIO`);

--
-- Indexes for table `Roles`
--
ALTER TABLE `Roles`
  ADD PRIMARY KEY (`ID_ROL`),
  ADD UNIQUE KEY `ID_ROL` (`ID_ROL`),
  ADD KEY `ID_ROL_2` (`ID_ROL`);

--
-- Indexes for table `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`ID_USUARIO`),
  ADD UNIQUE KEY `ID_USUARIO` (`ID_USUARIO`),
  ADD KEY `ID_USUARIO_2` (`ID_USUARIO`),
  ADD KEY `ID_ROL` (`ID_ROL`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Auditoria`
--
ALTER TABLE `Auditoria`
  MODIFY `ID_AUDITORIA_USUARIOS` bigint(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Roles`
--
ALTER TABLE `Roles`
  MODIFY `ID_ROL` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Usuarios`
--
ALTER TABLE `Usuarios`
  MODIFY `ID_USUARIO` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Auditoria`
--
ALTER TABLE `Auditoria`
  ADD CONSTRAINT `ID_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `Usuarios` (`ID_USUARIO`);

--
-- Constraints for table `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD CONSTRAINT `ID_ROL` FOREIGN KEY (`ID_ROL`) REFERENCES `Roles` (`ID_ROL`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

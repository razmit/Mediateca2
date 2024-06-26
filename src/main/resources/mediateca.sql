-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2024 at 08:10 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mediateca`
--

-- --------------------------------------------------------

--
-- Table structure for table `cdaudio`
--

CREATE TABLE `cdaudio` (
  `idCdAudio` bigint(11) NOT NULL,
  `idDocumento` bigint(11) DEFAULT NULL,
  `artista` varchar(255) DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `numCanciones` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cdaudio`
--

INSERT INTO `cdaudio` (`idCdAudio`, `idDocumento`, `artista`, `genero`, `duracion`, `numCanciones`) VALUES
(1, 1, 'Los Mediocres ', 'Crimen', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `documentos`
--

CREATE TABLE `documentos` (
  `idDocumento` bigint(11) NOT NULL,
  `idTipoDocumento` bigint(11) DEFAULT NULL,
  `titulo` varchar(255) NOT NULL,
  `autor` varchar(255) DEFAULT NULL,
  `anoPublicacion` int(11) DEFAULT NULL,
  `ubicacionFisica` varchar(100) DEFAULT NULL,
  `cantidadDisponible` int(11) NOT NULL,
  `estado` varchar(155) NOT NULL,
  `fechaAdquisicion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `documentos`
--

INSERT INTO `documentos` (`idDocumento`, `idTipoDocumento`, `titulo`, `autor`, `anoPublicacion`, `ubicacionFisica`, `cantidadDisponible`, `estado`, `fechaAdquisicion`) VALUES
(1, 4, 'Los Fabulosos Toyota', 'Los Mediocres Cadillac', 1991, 'Mexico', 122, 'Disponible', '2024-05-22'),
(2, 3, 'With me', 'M&M', 2010, 'USA', 1, 'Reservado', '2024-05-21');

-- --------------------------------------------------------

--
-- Table structure for table `documento_materia`
--

CREATE TABLE `documento_materia` (
  `doc_id` bigint(20) NOT NULL,
  `materia_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dvd`
--

CREATE TABLE `dvd` (
  `idDVD` bigint(11) NOT NULL,
  `idDocumento` bigint(11) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `libro`
--

CREATE TABLE `libro` (
  `idLibro` bigint(11) NOT NULL,
  `idDocumento` bigint(11) DEFAULT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `editorial` varchar(255) DEFAULT NULL,
  `numPaginas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `materias`
--

CREATE TABLE `materias` (
  `idMateria` bigint(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `materiasdocumentos`
--

CREATE TABLE `materiasdocumentos` (
  `idMateriaDocumento` bigint(11) NOT NULL,
  `idDocumento` bigint(11) NOT NULL,
  `idMateria` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `morausuario`
--

CREATE TABLE `morausuario` (
  `idMora` bigint(20) NOT NULL,
  `cantidadMora` int(11) NOT NULL,
  `tiempoMora` int(11) NOT NULL,
  `idUsuario` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `prestamos`
--

CREATE TABLE `prestamos` (
  `idPrestamo` bigint(11) NOT NULL,
  `idUsuario` bigint(11) DEFAULT NULL,
  `idDocumento` bigint(11) DEFAULT NULL,
  `fechaPrestamo` date DEFAULT NULL,
  `fechaDevolucion` date DEFAULT NULL,
  `estado` varchar(255) NOT NULL,
  `mora` decimal(38,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `revista`
--

CREATE TABLE `revista` (
  `idRevista` bigint(11) NOT NULL,
  `idDocumento` bigint(11) DEFAULT NULL,
  `issn` varchar(20) DEFAULT NULL,
  `editorial` varchar(255) DEFAULT NULL,
  `periodicidad` varchar(20) DEFAULT NULL,
  `fechaPublicacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tesis`
--

CREATE TABLE `tesis` (
  `idTesis` bigint(11) NOT NULL,
  `idDocumento` bigint(11) DEFAULT NULL,
  `directorTesis` varchar(255) DEFAULT NULL,
  `gradoObtenido` varchar(50) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `idTipoDocumento` bigint(11) NOT NULL,
  `nombreTipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tipodocumento`
--

INSERT INTO `tipodocumento` (`idTipoDocumento`, `nombreTipo`) VALUES
(1, 'Revista'),
(2, 'Tesis'),
(3, 'Libro'),
(4, 'CD');

-- --------------------------------------------------------

--
-- Table structure for table `tipos_usuarios`
--

CREATE TABLE `tipos_usuarios` (
  `user_id` bigint(20) NOT NULL,
  `userType_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tipousuarios`
--

CREATE TABLE `tipousuarios` (
  `idTipoUsuario` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tipousuarios`
--

INSERT INTO `tipousuarios` (`idTipoUsuario`, `nombre`) VALUES
(1, 'Administrador'),
(2, 'Docente'),
(3, 'Alumno');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` bigint(20) NOT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `nombreUsuario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `contrasena`, `nombreUsuario`) VALUES
(1, '$2a$12$mEwJTUODKcMvIuW0YIk4HO.hlQ0W/1T3/q2QoZuFylQRTmdZE37J6', 'jimmy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cdaudio`
--
ALTER TABLE `cdaudio`
  ADD PRIMARY KEY (`idCdAudio`),
  ADD KEY `idDocumento` (`idDocumento`);

--
-- Indexes for table `documentos`
--
ALTER TABLE `documentos`
  ADD PRIMARY KEY (`idDocumento`),
  ADD KEY `ID_Tipo_Documento` (`idTipoDocumento`);

--
-- Indexes for table `documento_materia`
--
ALTER TABLE `documento_materia`
  ADD KEY `FKgt0cgj50nlxldumfa8vr6kmn5` (`materia_id`),
  ADD KEY `FK1sqngkt21jard6g9xqoiklj85` (`doc_id`);

--
-- Indexes for table `dvd`
--
ALTER TABLE `dvd`
  ADD PRIMARY KEY (`idDVD`),
  ADD KEY `ID_Documento` (`idDocumento`);

--
-- Indexes for table `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`idLibro`),
  ADD KEY `ID_Documento` (`idDocumento`);

--
-- Indexes for table `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`idMateria`);

--
-- Indexes for table `materiasdocumentos`
--
ALTER TABLE `materiasdocumentos`
  ADD PRIMARY KEY (`idMateriaDocumento`),
  ADD KEY `documento_fk` (`idDocumento`),
  ADD KEY `materia_fk` (`idMateria`);

--
-- Indexes for table `morausuario`
--
ALTER TABLE `morausuario`
  ADD PRIMARY KEY (`idMora`),
  ADD KEY `FK4jvtlicty4uh76say775scint` (`idUsuario`);

--
-- Indexes for table `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`idPrestamo`),
  ADD KEY `ID_Usuario` (`idUsuario`),
  ADD KEY `ID_Documento` (`idDocumento`);

--
-- Indexes for table `revista`
--
ALTER TABLE `revista`
  ADD PRIMARY KEY (`idRevista`),
  ADD KEY `ID_Documento` (`idDocumento`);

--
-- Indexes for table `tesis`
--
ALTER TABLE `tesis`
  ADD PRIMARY KEY (`idTesis`),
  ADD KEY `ID_Documento` (`idDocumento`);

--
-- Indexes for table `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`idTipoDocumento`);

--
-- Indexes for table `tipos_usuarios`
--
ALTER TABLE `tipos_usuarios`
  ADD KEY `FKf2x4dw1vwlw4qofr5pnbxgyp2` (`userType_id`),
  ADD KEY `FKrjnfn5eb2wq6mph4fw2mr3rxc` (`user_id`);

--
-- Indexes for table `tipousuarios`
--
ALTER TABLE `tipousuarios`
  ADD PRIMARY KEY (`idTipoUsuario`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cdaudio`
--
ALTER TABLE `cdaudio`
  MODIFY `idCdAudio` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `documentos`
--
ALTER TABLE `documentos`
  MODIFY `idDocumento` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `dvd`
--
ALTER TABLE `dvd`
  MODIFY `idDVD` bigint(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `libro`
--
ALTER TABLE `libro`
  MODIFY `idLibro` bigint(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `materias`
--
ALTER TABLE `materias`
  MODIFY `idMateria` bigint(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `materiasdocumentos`
--
ALTER TABLE `materiasdocumentos`
  MODIFY `idMateriaDocumento` bigint(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `morausuario`
--
ALTER TABLE `morausuario`
  MODIFY `idMora` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `idPrestamo` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `revista`
--
ALTER TABLE `revista`
  MODIFY `idRevista` bigint(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tesis`
--
ALTER TABLE `tesis`
  MODIFY `idTesis` bigint(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `idTipoDocumento` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tipousuarios`
--
ALTER TABLE `tipousuarios`
  MODIFY `idTipoUsuario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cdaudio`
--
ALTER TABLE `cdaudio`
  ADD CONSTRAINT `cdaudio_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`);

--
-- Constraints for table `documentos`
--
ALTER TABLE `documentos`
  ADD CONSTRAINT `documentos_ibfk_1` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipodocumento` (`idTipoDocumento`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `documento_materia`
--
ALTER TABLE `documento_materia`
  ADD CONSTRAINT `FK1sqngkt21jard6g9xqoiklj85` FOREIGN KEY (`doc_id`) REFERENCES `documentos` (`idDocumento`),
  ADD CONSTRAINT `FKgt0cgj50nlxldumfa8vr6kmn5` FOREIGN KEY (`materia_id`) REFERENCES `materias` (`idMateria`);

--
-- Constraints for table `dvd`
--
ALTER TABLE `dvd`
  ADD CONSTRAINT `dvd_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`);

--
-- Constraints for table `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`);

--
-- Constraints for table `materiasdocumentos`
--
ALTER TABLE `materiasdocumentos`
  ADD CONSTRAINT `materiasdocumentos_ibfk_1` FOREIGN KEY (`idMateria`) REFERENCES `materias` (`idMateria`),
  ADD CONSTRAINT `materiasdocumentos_ibfk_2` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`);

--
-- Constraints for table `morausuario`
--
ALTER TABLE `morausuario`
  ADD CONSTRAINT `FK4jvtlicty4uh76say775scint` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

--
-- Constraints for table `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `revista`
--
ALTER TABLE `revista`
  ADD CONSTRAINT `revista_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`);

--
-- Constraints for table `tesis`
--
ALTER TABLE `tesis`
  ADD CONSTRAINT `tesis_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`idDocumento`);

--
-- Constraints for table `tipos_usuarios`
--
ALTER TABLE `tipos_usuarios`
  ADD CONSTRAINT `FKf2x4dw1vwlw4qofr5pnbxgyp2` FOREIGN KEY (`userType_id`) REFERENCES `tipousuarios` (`idTipoUsuario`),
  ADD CONSTRAINT `FKrjnfn5eb2wq6mph4fw2mr3rxc` FOREIGN KEY (`user_id`) REFERENCES `usuarios` (`idUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

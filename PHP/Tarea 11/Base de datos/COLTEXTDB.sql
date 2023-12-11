-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: coltext
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `domicilio`
--

DROP TABLE IF EXISTS `domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domicilio` (
  `iddomicilio` int NOT NULL AUTO_INCREMENT,
  `resumen` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `fechaEnvio` date NOT NULL,
  `estado` tinyint NOT NULL,
  `domiciliario` int NOT NULL,
  PRIMARY KEY (`iddomicilio`),
  KEY `domiciliario` (`domiciliario`),
  CONSTRAINT `domicilio_ibfk_1` FOREIGN KEY (`domiciliario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `idfactura` int NOT NULL AUTO_INCREMENT,
  `fechaFactura` date NOT NULL,
  `cantidadProductos` int NOT NULL,
  `detalladoProductos` int NOT NULL,
  `subTotal` decimal(3,0) NOT NULL,
  PRIMARY KEY (`idfactura`),
  KEY `detalladoProductos` (`detalladoProductos`),
  CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`detalladoProductos`) REFERENCES `insumo` (`idinsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestionadministracion`
--

DROP TABLE IF EXISTS `gestionadministracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestionadministracion` (
  `idAreaGestionAdministracion` int NOT NULL,
  `R.H` int NOT NULL,
  `listaPqrs` int NOT NULL,
  PRIMARY KEY (`idAreaGestionAdministracion`),
  KEY `R.H` (`R.H`),
  KEY `listaPqrs` (`listaPqrs`),
  CONSTRAINT `gestionadministracion_ibfk_1` FOREIGN KEY (`R.H`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `gestionadministracion_ibfk_2` FOREIGN KEY (`listaPqrs`) REFERENCES `pqrs` (`idPQR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestionadministracion`
--

LOCK TABLES `gestionadministracion` WRITE;
/*!40000 ALTER TABLE `gestionadministracion` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestionadministracion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestionbodega`
--

DROP TABLE IF EXISTS `gestionbodega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestionbodega` (
  `idAreaGestionBodega` int NOT NULL,
  `almacenista` int NOT NULL,
  `insumosvendidos` int NOT NULL,
  `listaInsumos` int NOT NULL,
  PRIMARY KEY (`idAreaGestionBodega`),
  KEY `almacenista` (`almacenista`),
  KEY `listaInsumos` (`listaInsumos`),
  KEY `insumosvendidos` (`insumosvendidos`),
  CONSTRAINT `gestionbodega_ibfk_1` FOREIGN KEY (`almacenista`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `gestionbodega_ibfk_2` FOREIGN KEY (`listaInsumos`) REFERENCES `insumo` (`idinsumo`),
  CONSTRAINT `gestionbodega_ibfk_3` FOREIGN KEY (`insumosvendidos`) REFERENCES `venta` (`idventa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestionbodega`
--

LOCK TABLES `gestionbodega` WRITE;
/*!40000 ALTER TABLE `gestionbodega` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestionbodega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumo`
--

DROP TABLE IF EXISTS `insumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insumo` (
  `idinsumo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `precioUnitario` decimal(3,0) NOT NULL,
  `descripcion` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`idinsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumo`
--

LOCK TABLES `insumo` WRITE;
/*!40000 ALTER TABLE `insumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `insumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pqrs`
--

DROP TABLE IF EXISTS `pqrs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pqrs` (
  `idPQR` int NOT NULL AUTO_INCREMENT,
  `fechaRadicado` date NOT NULL,
  `DescrpcionPqr` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `Idtrabajador` int NOT NULL,
  PRIMARY KEY (`idPQR`),
  KEY `Idtrabajador` (`Idtrabajador`),
  CONSTRAINT `pqrs_ibfk_1` FOREIGN KEY (`Idtrabajador`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pqrs`
--

LOCK TABLES `pqrs` WRITE;
/*!40000 ALTER TABLE `pqrs` DISABLE KEYS */;
/*!40000 ALTER TABLE `pqrs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocion`
--

DROP TABLE IF EXISTS `promocion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promocion` (
  `idpromocion` int NOT NULL AUTO_INCREMENT,
  `rangoFechas` date NOT NULL,
  `descripcion` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `insumoenDescuento` int NOT NULL,
  PRIMARY KEY (`idpromocion`),
  KEY `insumoenDescuento` (`insumoenDescuento`),
  CONSTRAINT `promocion_ibfk_1` FOREIGN KEY (`insumoenDescuento`) REFERENCES `insumo` (`idinsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocion`
--

LOCK TABLES `promocion` WRITE;
/*!40000 ALTER TABLE `promocion` DISABLE KEYS */;
/*!40000 ALTER TABLE `promocion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pyme`
--

DROP TABLE IF EXISTS `pyme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pyme` (
  `RUT` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `telefono` int NOT NULL,
  `correo` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `direccionPyme` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `empleados` int NOT NULL,
  PRIMARY KEY (`RUT`),
  KEY `trabajadores` (`empleados`),
  CONSTRAINT `pyme_ibfk_1` FOREIGN KEY (`empleados`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pyme`
--

LOCK TABLES `pyme` WRITE;
/*!40000 ALTER TABLE `pyme` DISABLE KEYS */;
/*!40000 ALTER TABLE `pyme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Trabajador'),(2,'Cliente'),(3,'Almacenista'),(4,'Vendedor'),(5,'R.H');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `apellidos` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `correo` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `celular` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `direccion` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `Rol` int NOT NULL,
  `password` varchar(30) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `Rol` (`Rol`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`Rol`) REFERENCES `rol` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1001,'Rosa','Garcia','rosgarcia@coltex.com','3010001234','carrea 4 # 35 - 21',1,'Rosa1001'),(1002,'Cristian','Arcila','criarcila@coltex.com','3010004567','calle 67a # 21 - 52',5,'Cristian1002'),(1003,'Jose','Santos','jossantos@coltex.com','3010006587','calle 35 # 45b - 32',4,'Jose1003'),(1004,'Camilo','Bustos','cambustos@coltex.com','3010006354','carrera 34 # 84 - 41',3,'Camilo1004');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `idventa` int NOT NULL AUTO_INCREMENT,
  `fehaventa` date NOT NULL,
  `valorNeto` decimal(3,0) NOT NULL,
  `insumos` int NOT NULL,
  `Factura` int NOT NULL,
  `vendedor` int NOT NULL,
  `domicilio` int NOT NULL,
  PRIMARY KEY (`idventa`),
  KEY `vendedor` (`vendedor`),
  KEY `Factura` (`Factura`),
  KEY `domicilio` (`domicilio`),
  KEY `insumos` (`insumos`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`vendedor`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`Factura`) REFERENCES `factura` (`idfactura`),
  CONSTRAINT `venta_ibfk_3` FOREIGN KEY (`domicilio`) REFERENCES `domicilio` (`iddomicilio`),
  CONSTRAINT `venta_ibfk_4` FOREIGN KEY (`insumos`) REFERENCES `insumo` (`idinsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas&fidelizacion`
--

DROP TABLE IF EXISTS `ventas&fidelizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas&fidelizacion` (
  `idAreaGestionVentas` int NOT NULL,
  `ingresoaCaja` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `rangodeFechas` date NOT NULL,
  `historicoVentas` int NOT NULL,
  `vendedor` int NOT NULL,
  `clientes` int NOT NULL,
  `promociones` int NOT NULL,
  PRIMARY KEY (`idAreaGestionVentas`),
  KEY `vendedor` (`vendedor`),
  KEY `clientes` (`clientes`),
  KEY `historicoVentas` (`historicoVentas`),
  KEY `promociones` (`promociones`),
  CONSTRAINT `ventas&fidelizacion_ibfk_1` FOREIGN KEY (`vendedor`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `ventas&fidelizacion_ibfk_2` FOREIGN KEY (`clientes`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `ventas&fidelizacion_ibfk_3` FOREIGN KEY (`historicoVentas`) REFERENCES `venta` (`idventa`),
  CONSTRAINT `ventas&fidelizacion_ibfk_4` FOREIGN KEY (`promociones`) REFERENCES `promocion` (`idpromocion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas&fidelizacion`
--

LOCK TABLES `ventas&fidelizacion` WRITE;
/*!40000 ALTER TABLE `ventas&fidelizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas&fidelizacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-20  0:59:41

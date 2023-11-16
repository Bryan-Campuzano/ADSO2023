/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.28-MariaDB : Database - coltext
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`coltext` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `coltext`;

/*Table structure for table `domicilio` */

DROP TABLE IF EXISTS `domicilio`;

CREATE TABLE `domicilio` (
  `iddomicilio` int(11) NOT NULL AUTO_INCREMENT,
  `resumen` varchar(45) NOT NULL,
  `fechaEnvio` date NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `domiciliario` int(11) NOT NULL,
  PRIMARY KEY (`iddomicilio`),
  KEY `domiciliario` (`domiciliario`),
  CONSTRAINT `domicilio_ibfk_1` FOREIGN KEY (`domiciliario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `domicilio` */

/*Table structure for table `factura` */

DROP TABLE IF EXISTS `factura`;

CREATE TABLE `factura` (
  `idfactura` int(11) NOT NULL AUTO_INCREMENT,
  `fechaFactura` date NOT NULL,
  `cantidadProductos` int(11) NOT NULL,
  `detalladoProductos` int(11) NOT NULL,
  `subTotal` decimal(3,0) NOT NULL,
  PRIMARY KEY (`idfactura`),
  KEY `detalladoProductos` (`detalladoProductos`),
  CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`detalladoProductos`) REFERENCES `insumo` (`idinsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `factura` */

/*Table structure for table `gestionadministracion` */

DROP TABLE IF EXISTS `gestionadministracion`;

CREATE TABLE `gestionadministracion` (
  `idAreaGestionAdministracion` int(11) NOT NULL,
  `R.H` int(11) NOT NULL,
  `listaPqrs` int(11) NOT NULL,
  PRIMARY KEY (`idAreaGestionAdministracion`),
  KEY `R.H` (`R.H`),
  KEY `listaPqrs` (`listaPqrs`),
  CONSTRAINT `gestionadministracion_ibfk_1` FOREIGN KEY (`R.H`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `gestionadministracion_ibfk_2` FOREIGN KEY (`listaPqrs`) REFERENCES `pqrs` (`idPQR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `gestionadministracion` */

/*Table structure for table `gestionbodega` */

DROP TABLE IF EXISTS `gestionbodega`;

CREATE TABLE `gestionbodega` (
  `idAreaGestionBodega` int(11) NOT NULL,
  `almacenista` int(11) NOT NULL,
  `insumosvendidos` int(11) NOT NULL,
  `listaInsumos` int(11) NOT NULL,
  PRIMARY KEY (`idAreaGestionBodega`),
  KEY `almacenista` (`almacenista`),
  KEY `listaInsumos` (`listaInsumos`),
  KEY `insumosvendidos` (`insumosvendidos`),
  CONSTRAINT `gestionbodega_ibfk_1` FOREIGN KEY (`almacenista`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `gestionbodega_ibfk_2` FOREIGN KEY (`listaInsumos`) REFERENCES `insumo` (`idinsumo`),
  CONSTRAINT `gestionbodega_ibfk_3` FOREIGN KEY (`insumosvendidos`) REFERENCES `venta` (`idventa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `gestionbodega` */

/*Table structure for table `insumo` */

DROP TABLE IF EXISTS `insumo`;

CREATE TABLE `insumo` (
  `idinsumo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `precioUnitario` decimal(3,0) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`idinsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `insumo` */

/*Table structure for table `pqrs` */

DROP TABLE IF EXISTS `pqrs`;

CREATE TABLE `pqrs` (
  `idPQR` int(11) NOT NULL AUTO_INCREMENT,
  `fechaRadicado` date NOT NULL,
  `DescrpcionPqr` varchar(45) NOT NULL,
  `Idtrabajador` int(11) NOT NULL,
  PRIMARY KEY (`idPQR`),
  KEY `Idtrabajador` (`Idtrabajador`),
  CONSTRAINT `pqrs_ibfk_1` FOREIGN KEY (`Idtrabajador`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `pqrs` */

/*Table structure for table `promocion` */

DROP TABLE IF EXISTS `promocion`;

CREATE TABLE `promocion` (
  `idpromocion` int(11) NOT NULL AUTO_INCREMENT,
  `rangoFechas` date NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `insumoenDescuento` int(11) NOT NULL,
  PRIMARY KEY (`idpromocion`),
  KEY `insumoenDescuento` (`insumoenDescuento`),
  CONSTRAINT `promocion_ibfk_1` FOREIGN KEY (`insumoenDescuento`) REFERENCES `insumo` (`idinsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `promocion` */

/*Table structure for table `pyme` */

DROP TABLE IF EXISTS `pyme`;

CREATE TABLE `pyme` (
  `RUT` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` int(11) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `direccionPyme` varchar(45) NOT NULL,
  `empleados` int(11) NOT NULL,
  PRIMARY KEY (`RUT`),
  KEY `trabajadores` (`empleados`),
  CONSTRAINT `pyme_ibfk_1` FOREIGN KEY (`empleados`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `pyme` */

/*Table structure for table `rol` */

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `rol` */

insert  into `rol`(`idRol`,`Descripcion`) values (1,'Trabajador'),(2,'Cliente'),(3,'Almacenista'),(4,'Vendedor'),(5,'R.H');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `celular` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `Rol` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `Rol` (`Rol`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`Rol`) REFERENCES `rol` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `usuario` */

insert  into `usuario`(`idUsuario`,`nombres`,`apellidos`,`correo`,`celular`,`direccion`,`Rol`) values (1001,'Rosa','Garcia','rosgarcia@coltex.com','3010001234','carrea 4 # 35 - 21',1),(1002,'Cristian','Arcila','criarcila@coltex.com','3010004567','calle 67a # 21 - 52',5),(1003,'Jose','Santos','jossantos@coltex.com','3010006587','calle 35 # 45b - 32',4),(1004,'Camilo','Bustos','cambustos@coltex.com','3010006354','carrera 34 # 84 - 41',3);

/*Table structure for table `venta` */

DROP TABLE IF EXISTS `venta`;

CREATE TABLE `venta` (
  `idventa` int(11) NOT NULL AUTO_INCREMENT,
  `fehaventa` date NOT NULL,
  `valorNeto` decimal(3,0) NOT NULL,
  `insumos` int(11) NOT NULL,
  `Factura` int(11) NOT NULL,
  `vendedor` int(11) NOT NULL,
  `domicilio` int(11) NOT NULL,
  PRIMARY KEY (`idventa`),
  KEY `vendedor` (`vendedor`),
  KEY `Factura` (`Factura`),
  KEY `domicilio` (`domicilio`),
  KEY `insumos` (`insumos`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`vendedor`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`Factura`) REFERENCES `factura` (`idfactura`),
  CONSTRAINT `venta_ibfk_3` FOREIGN KEY (`domicilio`) REFERENCES `domicilio` (`iddomicilio`),
  CONSTRAINT `venta_ibfk_4` FOREIGN KEY (`insumos`) REFERENCES `insumo` (`idinsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `venta` */

/*Table structure for table `ventas&fidelizacion` */

DROP TABLE IF EXISTS `ventas&fidelizacion`;

CREATE TABLE `ventas&fidelizacion` (
  `idAreaGestionVentas` int(11) NOT NULL,
  `ingresoaCaja` varchar(45) NOT NULL,
  `rangodeFechas` date NOT NULL,
  `historicoVentas` int(11) NOT NULL,
  `vendedor` int(11) NOT NULL,
  `clientes` int(11) NOT NULL,
  `promociones` int(11) NOT NULL,
  PRIMARY KEY (`idAreaGestionVentas`),
  KEY `vendedor` (`vendedor`),
  KEY `clientes` (`clientes`),
  KEY `historicoVentas` (`historicoVentas`),
  KEY `promociones` (`promociones`),
  CONSTRAINT `ventas&fidelizacion_ibfk_1` FOREIGN KEY (`vendedor`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `ventas&fidelizacion_ibfk_2` FOREIGN KEY (`clientes`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `ventas&fidelizacion_ibfk_3` FOREIGN KEY (`historicoVentas`) REFERENCES `venta` (`idventa`),
  CONSTRAINT `ventas&fidelizacion_ibfk_4` FOREIGN KEY (`promociones`) REFERENCES `promocion` (`idpromocion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ventas&fidelizacion` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

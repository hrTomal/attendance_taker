-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2019 at 09:55 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `c06`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendancesheet`
--

CREATE TABLE `attendancesheet` (
  `studentId` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `class1` varchar(1) NOT NULL DEFAULT '0',
  `class2` varchar(1) NOT NULL DEFAULT '0',
  `class3` varchar(1) NOT NULL DEFAULT '0',
  `class4` varchar(1) NOT NULL DEFAULT '0',
  `class5` varchar(1) NOT NULL DEFAULT '0',
  `class6` varchar(1) NOT NULL DEFAULT '0',
  `class7` varchar(1) NOT NULL DEFAULT '0',
  `class8` varchar(1) NOT NULL DEFAULT '0',
  `class9` varchar(1) NOT NULL DEFAULT '0',
  `class10` varchar(1) NOT NULL DEFAULT '0',
  `class11` varchar(1) NOT NULL DEFAULT '0',
  `class12` varchar(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendancesheet`
--

INSERT INTO `attendancesheet` (`studentId`, `name`, `class1`, `class2`, `class3`, `class4`, `class5`, `class6`, `class7`, `class8`, `class9`, `class10`, `class11`, `class12`) VALUES
('17-xxxxx-2', 'Alice', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
('id1', 'Steve', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
('id2', 'Lesley', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
('id3', 'Jeff', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
('id5', 'Bejos', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
('id6', 'Bill', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
('id7', 'Gates', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `empId` varchar(10) NOT NULL,
  `employeeName` varchar(30) NOT NULL,
  `designation` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`empId`, `employeeName`, `designation`) VALUES
('', '', ''),
('A', 'MRS B', 'Admin'),
('A3', 'Tom', 'Faculty'),
('B', 'Jerry', 'Faculty');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `empId` varchar(10) NOT NULL,
  `password` varchar(16) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`empId`, `password`, `status`) VALUES
('A', '2', 0),
('A3', '4', 1),
('B', '1', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendancesheet`
--
ALTER TABLE `attendancesheet`
  ADD PRIMARY KEY (`name`,`class1`,`class2`,`class3`,`class4`,`class5`,`class6`,`class7`,`class8`,`class9`,`class10`,`class11`,`class12`),
  ADD UNIQUE KEY `unique` (`studentId`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employeeName`,`designation`),
  ADD UNIQUE KEY `unique` (`empId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`password`,`status`),
  ADD UNIQUE KEY `unique` (`empId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

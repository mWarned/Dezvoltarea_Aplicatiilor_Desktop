-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 13, 2023 at 10:54 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `polldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `persoane`
--

CREATE TABLE `persoane` (
  `ID` int(11) NOT NULL,
  `PID` int(11) NOT NULL,
  `Nume` varchar(50) NOT NULL,
  `Prenume` varchar(50) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `nrTelefon` varchar(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `dataNasterii` date NOT NULL,
  `casatorit` tinyint(1) NOT NULL,
  `divortat` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `persoane`
--

INSERT INTO `persoane` (`ID`, `PID`, `Nume`, `Prenume`, `sex`, `nrTelefon`, `email`, `dataNasterii`, `casatorit`, `divortat`) VALUES
(1, 1, 'Mihai', 'Jizdan', 'm', '067523462', 'mihaij@gmail.com', '2004-07-09', 0, 1),
(2, 2, 'Smith', 'John', 'm', '023525478', 'john.smith@example.com', '1987-01-15', 1, 1),
(3, 3, 'Johnson', 'Alice', 'f', '023715254', 'alice.johnson@example.com', '2001-04-10', 1, 0),
(4, 4, 'Davis', 'Robert', 'm', '032669158', 'robert.davis@example.com', '1989-07-20', 0, 0),
(5, 5, 'Wilson', 'Sarah', 'f', '038956924', 'sarah.wilson@example.com', '1990-10-05', 0, 1),
(6, 6, 'Brown', 'Michael', 'm', '079096998', 'michael.brown@example.com', '1991-02-28', 1, 0),
(7, 7, 'Johnson', 'Lisa', 'f', '035753130', 'lisa.johnson@example.com', '2003-06-15', 0, 1),
(8, 8, 'Miller', 'David', 'm', '026460970', 'david.miller@example.com', '1993-09-30', 1, 1),
(9, 9, 'Martinez', 'Laura', 'f', '066844229', 'laura.martinez@example.com', '1994-12-15', 0, 0),
(10, 10, 'Garcia', 'William', 'm', '039539761', 'william.garcia@example.com', '2000-04-03', 1, 1),
(11, 11, 'Smith', 'Jennifer', 'f', '063509348', 'jennifer.smith@example.com', '1996-08-12', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `polls`
--

CREATE TABLE `polls` (
  `ID` int(11) NOT NULL,
  `PID` int(11) NOT NULL,
  `Person` int(11) DEFAULT NULL,
  `Poll` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `polls`
--

INSERT INTO `polls` (`ID`, `PID`, `Person`, `Poll`) VALUES
(4, 1, 1, 1),
(5, 2, 2, 2),
(6, 3, 3, 3),
(7, 4, NULL, 4),
(8, 5, 4, 5),
(9, 6, 5, 6),
(10, 7, 6, 7),
(12, 9, 7, 9),
(13, 10, NULL, 10),
(14, 11, 8, 11),
(15, 12, 9, 12),
(16, 13, 10, 13),
(17, 14, 11, 14),
(18, 15, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `sondaje`
--

CREATE TABLE `sondaje` (
  `ID` int(11) NOT NULL,
  `PID` int(11) NOT NULL,
  `poll1` varchar(255) NOT NULL,
  `poll2` varchar(255) NOT NULL,
  `poll3` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sondaje`
--

INSERT INTO `sondaje` (`ID`, `PID`, `poll1`, `poll2`, `poll3`) VALUES
(1, 1, 'Negru', 'Ingetata', 'Metal'),
(2, 2, 'Roșu', 'Sushi', 'Pop'),
(3, 3, 'Verde', 'Lasagna', 'Jazz'),
(4, 4, 'Galben', 'Burger', 'Rap'),
(5, 5, 'Portocaliu', 'Paste', 'Country'),
(6, 6, 'Violet', 'Steak', 'Blues'),
(7, 7, 'Roz', 'Tacos', 'Classical'),
(8, 8, 'Gri', 'Fish and Chips', 'Electronic'),
(9, 9, 'Negru', 'Chinese', 'Hip-Hop'),
(10, 10, 'Maro', 'Indian', 'Reggae'),
(11, 11, 'Auriu', 'Greek', 'Metal'),
(12, 12, 'Argintiu', 'Mediterranean', 'Folk'),
(13, 13, 'Cyan', 'Vegetarian', 'Indie'),
(14, 14, 'Turcoaz', 'BBQ', 'Alternative'),
(15, 15, 'Magenta', 'Vegan', 'R&B');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `persoane`
--
ALTER TABLE `persoane`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `polls`
--
ALTER TABLE `polls`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `PersoaneFRK` (`Person`),
  ADD KEY `PollsFRK` (`Poll`);

--
-- Indexes for table `sondaje`
--
ALTER TABLE `sondaje`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `persoane`
--
ALTER TABLE `persoane`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `polls`
--
ALTER TABLE `polls`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `sondaje`
--
ALTER TABLE `sondaje`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `polls`
--
ALTER TABLE `polls`
  ADD CONSTRAINT `PersoaneFRK` FOREIGN KEY (`Person`) REFERENCES `persoane` (`ID`),
  ADD CONSTRAINT `PollsFRK` FOREIGN KEY (`Poll`) REFERENCES `sondaje` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

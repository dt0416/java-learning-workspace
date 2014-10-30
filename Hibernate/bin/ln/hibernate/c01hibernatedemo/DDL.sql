CREATE TABLE `course` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);
CREATE TABLE `student` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `NAME` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);
CREATE TABLE `studentcourse` (
  `SID` int(11) DEFAULT NULL,
  `CID` int(11) DEFAULT NULL,
  `GRADE` int(11) DEFAULT NULL,
  KEY `SID` (`SID`),
  KEY `CID` (`CID`),
  CONSTRAINT `studentcourse_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`ID`),
  CONSTRAINT `studentcourse_ibfk_2` FOREIGN KEY (`CID`) REFERENCES `course` (`ID`)
);
--Cascade½d¨Ò¨Ï¥Îtable
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `room_id` (`room_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
);
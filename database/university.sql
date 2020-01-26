-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Янв 26 2020 г., 13:26
-- Версия сервера: 10.4.10-MariaDB
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `university`
--

-- --------------------------------------------------------

--
-- Структура таблицы `burden`
--

CREATE TABLE `burden` (
  `ID` int(11) NOT NULL,
  `lector_id` int(11) NOT NULL,
  `departament_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `burden`
--

INSERT INTO `burden` (`ID`, `lector_id`, `departament_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 2, 2),
(5, 3, 3),
(6, 4, 2),
(7, 4, 3),
(8, 5, 1),
(9, 6, 1),
(10, 6, 2),
(11, 6, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `departament`
--

CREATE TABLE `departament` (
  `ID` int(11) NOT NULL,
  `departament_name` varchar(100) NOT NULL,
  `head_of_dept_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `departament`
--

INSERT INTO `departament` (`ID`, `departament_name`, `head_of_dept_id`) VALUES
(1, 'Facult Inf Technology', 1),
(2, 'Faculty Finance', 2),
(3, 'Faculty Mechan Engineering', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `head_of_departments`
--

CREATE TABLE `head_of_departments` (
  `ID` int(11) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `head_of_departments`
--

INSERT INTO `head_of_departments` (`ID`, `fname`, `lname`, `age`) VALUES
(1, 'Yaroslav', 'Trotskiy', 55),
(2, 'Nikita', 'Gordon', 67),
(3, 'Marina', 'Alyakina', 34);

-- --------------------------------------------------------

--
-- Структура таблицы `lector`
--

CREATE TABLE `lector` (
  `ID` int(11) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `stage_id` int(11) NOT NULL,
  `salary_usa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `lector`
--

INSERT INTO `lector` (`ID`, `fname`, `lname`, `age`, `stage_id`, `salary_usa`) VALUES
(1, 'Ivan', 'Ivanov', 23, 1, 340),
(2, 'Petr', 'Petrov', 43, 2, 515),
(3, 'Dmitry', 'Domkin', 66, 3, 870),
(4, 'Victor', 'Jurba', 30, 1, 320),
(5, 'Sergei', 'Holub', 44, 3, 920),
(6, 'Ihor', 'Talkov', 42, 3, 950);

-- --------------------------------------------------------

--
-- Структура таблицы `stage`
--

CREATE TABLE `stage` (
  `ID` int(11) NOT NULL,
  `stage_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `stage`
--

INSERT INTO `stage` (`ID`, `stage_name`) VALUES
(1, 'assistant'),
(2, 'associate professor'),
(3, 'professor');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `burden`
--
ALTER TABLE `burden`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `departament`
--
ALTER TABLE `departament`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `head_of_departments`
--
ALTER TABLE `head_of_departments`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `lector`
--
ALTER TABLE `lector`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `stage`
--
ALTER TABLE `stage`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `burden`
--
ALTER TABLE `burden`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT для таблицы `departament`
--
ALTER TABLE `departament`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `head_of_departments`
--
ALTER TABLE `head_of_departments`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `lector`
--
ALTER TABLE `lector`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT для таблицы `stage`
--
ALTER TABLE `stage`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

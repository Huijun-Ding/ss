-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 23 oct. 2020 à 11:51
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `dolt`
--

-- --------------------------------------------------------

--
-- Structure de la table `avoir`
--

CREATE TABLE `avoir` (
  `Code_Intervenant` int(11) NOT NULL,
  `Code_competence` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `Code_client` int(11) NOT NULL,
  `TypeC` varchar(100) NOT NULL,
  `NomC` varchar(100) DEFAULT NULL,
  `PrenomC` varchar(100) DEFAULT NULL,
  `TelC` varchar(30) NOT NULL,
  `EmailC` varchar(100) NOT NULL,
  `NumRue` int(11) NOT NULL,
  `NomRue` varchar(100) NOT NULL,
  `VilleC` varchar(100) NOT NULL,
  `CodePostal` text NOT NULL,
  `NumCarteBancaire` text NOT NULL,
  `Civilite` varchar(20) DEFAULT NULL,
  `RaisonSociale` varchar(150) NOT NULL,
  `NumeroSiret` int(11) NOT NULL,
  `NomCorrespondant` varchar(150) NOT NULL,
  `PrenomCorrespondant` varchar(150) NOT NULL,
  `Domaine` varchar(100) NOT NULL,
  `Password` text NOT NULL,
  `NoteC` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`Code_client`, `TypeC`, `NomC`, `PrenomC`, `TelC`, `EmailC`, `NumRue`, `NomRue`, `VilleC`, `CodePostal`, `NumCarteBancaire`, `Civilite`, `RaisonSociale`, `NumeroSiret`, `NomCorrespondant`, `PrenomCorrespondant`, `Domaine`, `Password`, `NoteC`) VALUES
(1, '', 'hello', '', '', 'email@com', 0, '', '', '0', '0', '', '', 0, '', '', '', '', 0),
(2, 'E', NULL, NULL, '1', '354666', 2, '1', '1', '1', '1', NULL, '1', 1, '1', '1', '1', '', 0),
(3, '', NULL, NULL, '', '929302356@qq.com', 0, '', '', '0', '0', NULL, '', 0, '', '', '', '049988', 0),
(4, '', NULL, NULL, '', '1', 0, '', '', '0', '0', NULL, '', 0, '', '', '', '2', 0);

-- --------------------------------------------------------

--
-- Structure de la table `competence`
--

CREATE TABLE `competence` (
  `Code_competence` int(11) NOT NULL,
  `Libelle` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `estcompose`
--

CREATE TABLE `estcompose` (
  `ID_tache_Compose` int(11) NOT NULL,
  `ID_tache_composant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `intervenant`
--

CREATE TABLE `intervenant` (
  `Code_Intervevant` int(11) NOT NULL,
  `Nom_Inter` varchar(100) NOT NULL,
  `Prenom_Inter` varchar(150) NOT NULL,
  `Telephone_Inter` varchar(50) NOT NULL,
  `Email_Inter` varchar(100) NOT NULL,
  `Num_Rue_Inter` int(11) NOT NULL,
  `Nom_Rue_Inter` varchar(100) NOT NULL,
  `Ville_Inter` varchar(100) NOT NULL,
  `Code_Postal` text NOT NULL,
  `Numero_carte_Bancaire` text NOT NULL,
  `Password` text NOT NULL,
  `NoteIn` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `intervenant`
--

INSERT INTO `intervenant` (`Code_Intervevant`, `Nom_Inter`, `Prenom_Inter`, `Telephone_Inter`, `Email_Inter`, `Num_Rue_Inter`, `Nom_Rue_Inter`, `Ville_Inter`, `Code_Postal`, `Numero_carte_Bancaire`, `Password`, `NoteIn`) VALUES
(1, 'Hello', 'World', '', '2', 0, '', '', '0', '0', '2', 0),
(2, 'j', 'j', 'h', 'hello', 0, 'j', 'heu', 'hju', 'hjj', 'cccc', 0),
(3, 'j', 'j', 'h', 'hello', 0, 'j', 'heu', 'hju', 'hjj', 'cccc', 0);

-- --------------------------------------------------------

--
-- Structure de la table `intervenir`
--

CREATE TABLE `intervenir` (
  `Code_Intervenant` int(11) NOT NULL,
  `ID_tache` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `necessiter`
--

CREATE TABLE `necessiter` (
  `Tache_id` int(11) DEFAULT NULL,
  `Competence_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE `paiement` (
  `Code_client` int(11) NOT NULL,
  `ID_tache` int(11) NOT NULL,
  `DateP` date NOT NULL,
  `MontantP` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `recupaiement`
--

CREATE TABLE `recupaiement` (
  `Code_Intervenant` int(11) NOT NULL,
  `ID_tache` int(11) NOT NULL,
  `DateRP` date NOT NULL,
  `Montant` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE `tache` (
  `ID_tache` int(11) NOT NULL,
  `Nom_tache` varchar(150) NOT NULL,
  `Description` varchar(300) NOT NULL,
  `Nb_personne` int(11) NOT NULL,
  `Delais` text NOT NULL,
  `Prix` float NOT NULL,
  `Domaine_tache` varchar(200) NOT NULL,
  `Etat_Tache` varchar(50) NOT NULL,
  `Date_deb` text NOT NULL,
  `Date_Fin` text NOT NULL,
  `Code_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`ID_tache`, `Nom_tache`, `Description`, `Nb_personne`, `Delais`, `Prix`, `Domaine_tache`, `Etat_Tache`, `Date_deb`, `Date_Fin`, `Code_client`) VALUES
(1, '', 'helo', 0, '', 0, '', 'EN_COURS', '', '', 3),
(2, 'hello', 'h', 2, '0', 22, 'hh', 'EN_COURS', 'hello', 'hello', 1),
(3, 'hello', 'h', 2, '0', 22.45, 'hello', 'EN_COURS', '234', '333', 1),
(4, 'hgjghjg', 'N?.NJK', 2, '', 22.45, 'C++', 'EN_COURS', '1', '1', 4),
(5, 'jing', 'hiell', 4, '', 22.45, 'C++', 'EN_COURS', '1', '2', 4);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `avoir`
--
ALTER TABLE `avoir`
  ADD KEY `Code_Intervenant` (`Code_Intervenant`),
  ADD KEY `Code_competence` (`Code_competence`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`Code_client`);

--
-- Index pour la table `competence`
--
ALTER TABLE `competence`
  ADD PRIMARY KEY (`Code_competence`);

--
-- Index pour la table `estcompose`
--
ALTER TABLE `estcompose`
  ADD KEY `ID_tache_Compose` (`ID_tache_Compose`),
  ADD KEY `ID_tache_composant` (`ID_tache_composant`);

--
-- Index pour la table `intervenant`
--
ALTER TABLE `intervenant`
  ADD PRIMARY KEY (`Code_Intervevant`);

--
-- Index pour la table `intervenir`
--
ALTER TABLE `intervenir`
  ADD KEY `Code_Intervenant` (`Code_Intervenant`),
  ADD KEY `ID_tache` (`ID_tache`);

--
-- Index pour la table `necessiter`
--
ALTER TABLE `necessiter`
  ADD KEY `FK_tache` (`Tache_id`),
  ADD KEY `FK_competence` (`Competence_id`);

--
-- Index pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD KEY `Code_client` (`Code_client`),
  ADD KEY `ID_tache` (`ID_tache`);

--
-- Index pour la table `recupaiement`
--
ALTER TABLE `recupaiement`
  ADD KEY `Code_Intervenant` (`Code_Intervenant`),
  ADD KEY `ID_tache` (`ID_tache`);

--
-- Index pour la table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`ID_tache`),
  ADD KEY `Code_client` (`Code_client`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `Code_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `competence`
--
ALTER TABLE `competence`
  MODIFY `Code_competence` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `intervenant`
--
ALTER TABLE `intervenant`
  MODIFY `Code_Intervevant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
  MODIFY `ID_tache` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `avoir`
--
ALTER TABLE `avoir`
  ADD CONSTRAINT `avoir_ibfk_1` FOREIGN KEY (`Code_competence`) REFERENCES `competence` (`Code_competence`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `avoir_ibfk_2` FOREIGN KEY (`Code_Intervenant`) REFERENCES `intervenant` (`Code_Intervevant`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `estcompose`
--
ALTER TABLE `estcompose`
  ADD CONSTRAINT `estcompose_ibfk_1` FOREIGN KEY (`ID_tache_Compose`) REFERENCES `tache` (`ID_tache`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `estcompose_ibfk_2` FOREIGN KEY (`ID_tache_composant`) REFERENCES `tache` (`ID_tache`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `intervenir`
--
ALTER TABLE `intervenir`
  ADD CONSTRAINT `intervenir_ibfk_1` FOREIGN KEY (`ID_tache`) REFERENCES `tache` (`ID_tache`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `intervenir_ibfk_2` FOREIGN KEY (`Code_Intervenant`) REFERENCES `intervenant` (`Code_Intervevant`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `necessiter`
--
ALTER TABLE `necessiter`
  ADD CONSTRAINT `FK_competence` FOREIGN KEY (`Competence_id`) REFERENCES `competence` (`Code_competence`),
  ADD CONSTRAINT `FK_tache` FOREIGN KEY (`Tache_id`) REFERENCES `tache` (`ID_tache`);

--
-- Contraintes pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD CONSTRAINT `paiement_ibfk_1` FOREIGN KEY (`Code_client`) REFERENCES `client` (`Code_client`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `paiement_ibfk_2` FOREIGN KEY (`ID_tache`) REFERENCES `tache` (`ID_tache`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `recupaiement`
--
ALTER TABLE `recupaiement`
  ADD CONSTRAINT `recupaiement_ibfk_1` FOREIGN KEY (`ID_tache`) REFERENCES `tache` (`ID_tache`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `recupaiement_ibfk_2` FOREIGN KEY (`Code_Intervenant`) REFERENCES `intervenant` (`Code_Intervevant`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `tache_ibfk_1` FOREIGN KEY (`Code_client`) REFERENCES `client` (`Code_client`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

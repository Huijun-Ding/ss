-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 20 oct. 2020 à 11:10
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bd_dolt`
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
  `NomC` varchar(100) NOT NULL,
  `PrenomC` varchar(100) NOT NULL,
  `TelC` varchar(30) NOT NULL,
  `EmailC` varchar(100) NOT NULL,
  `NumRue` int(11) NOT NULL,
  `NomRue` varchar(100) NOT NULL,
  `VilleC` varchar(100) NOT NULL,
  `CodePostal` int(11) NOT NULL,
  `NumCarteBancaire` int(11) NOT NULL,
  `Civilite` varchar(20) NOT NULL,
  `RaisonSociale` varchar(150) NOT NULL,
  `NumeroSiret` int(11) NOT NULL,
  `NomCorrespondant` varchar(150) NOT NULL,
  `PrenomCorrespondant` varchar(150) NOT NULL,
  `Domaine` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `Code_Postal` int(11) NOT NULL,
  `Numero_carte_Bancaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `Delais` date NOT NULL,
  `Prix` float NOT NULL,
  `Domaine_tache` varchar(200) NOT NULL,
  `Etat_Tache` varchar(50) NOT NULL,
  `Date_deb` date NOT NULL,
  `Date_Fin` date NOT NULL,
  `Code_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  MODIFY `Code_client` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `competence`
--
ALTER TABLE `competence`
  MODIFY `Code_competence` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `intervenant`
--
ALTER TABLE `intervenant`
  MODIFY `Code_Intervevant` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
  MODIFY `ID_tache` int(11) NOT NULL AUTO_INCREMENT;

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

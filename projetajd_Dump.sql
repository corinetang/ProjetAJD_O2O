-- phpMyAdmin SQL Dump
-- version 4.4.9
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Lun 19 Juin 2017 à 00:59
-- Version du serveur :  5.5.42
-- Version de PHP :  5.5.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `projetajd_o2o`
--

-- --------------------------------------------------------

--
-- Structure de la table `espace`
--

CREATE TABLE `espace` (
  `id` int(11) NOT NULL,
  `superficie` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `prix` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `local_id` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `espace`
--

INSERT INTO `espace` (`id`, `superficie`, `type`, `photo`, `prix`, `description`, `titre`, `local_id`) VALUES
(1, 50, 'BUREAU', 'https://s-media-cache-ak0.pinimg.com/originals/ce/ba/10/ceba10272d63a41beaff1768437b1205.jpg', 100, NULL, 'Bureau en or', 1),
(2, 35, 'BUREAU', 'http://img.decision-achats.fr/Img/BREVE/2014/1/232368/quoi-ressemblera-votre-espace-travail-2030--F.jpg', 80, NULL, 'Bureau avec canapé', 2),
(3, 30, 'BUREAU', 'http://img.chefdentreprise.com/Img/BREVE/2014/2/234029/manque-hygiene-bureau-coute-milliards-euros-F.jpg', 70, '\n\n', 'Bureau 25', 2),
(4, 150, 'ETAGE', 'http://img.chefdentreprise.com/Img/BREVE/2015/6/256604/Locaux-Melty-F.jpg', 200, NULL, 'Etage 2 de la tour manhattan', 2),
(5, 200, 'ETAGE', 'http://www.universentreprises.fr/wp-content/uploads/2014/09/eclairage-adapte-aux-postes-de-travail-eclairage-pour-bureaux.jpg', 400, NULL, 'Etage avec rooftop', 2),
(6, 15, 'SALLE_REUNION', 'http://media.mbh.qc.ca/webfolder_download/ecd68ff9e3494f2c6f65b10067bfcaca/dscf7516/c343c7e9e932023c3cdfd7c08e2cc98bd80dc07a/dscf7516.jpg', 100, NULL, 'Reunion au sommet', 1),
(7, 20, 'SALLE_REUNION', 'http://blogs.lentreprise.com/deco-bureau/files/2015/05/CCE1.jpg', 110, NULL, 'Salle de reunion avec projo', 2),
(8, 10, 'SALLE_REUNION', 'http://www.lespiedssurlatable.com/static/5305/31669/258075/chaises-de-bureau-sur-mesure-pied-tine-les-Pieds-Sur-la-Table-meubles-design-modulables-et-colores-realisation-bureaux-entreprise.jpg', 90, NULL, 'Salle de reunion sans fenetre', 2),
(9, 20, 'BUREAU', 'http://knowledge.essec.edu/media/cache/6f/d5/6fd5c6de99e1d3d96828550d340d1e50.jpg', 100, 'Bureau avec superbe vue et un salon inclus', 'Bureau chairman', 1),
(10, 100, 'ETAGE', 'http://www.isospace.fr/sites/default/files/styles/colorbox_800x600/public/imgPublication/quant16.jpg?itok=usjSgN29', 1000, NULL, '3e étage', 1),
(11, 30, 'SALLE_REUNION', 'https://s-media-cache-ak0.pinimg.com/originals/35/60/94/3560943129e0ed2de265a151d1d73c5a.jpg', 100, NULL, 'Petite salle de réunion', 1);

-- --------------------------------------------------------

--
-- Structure de la table `espace_locations`
--

CREATE TABLE `espace_locations` (
  `espace_id` int(11) NOT NULL,
  `locations_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `local`
--

CREATE TABLE `local` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `local`
--

INSERT INTO `local` (`id`, `address`, `nom`, `photo`, `ville`) VALUES
(1, 'Rue Galilé', 'Buro Club', 'https://immobilier.cbre.fr/Documents/Property/Large/30139.jpg', 'Levallois'),
(2, '5 place de l''Iris', 'Tour manatthan', 'http://www.cabinet-medical.net/page/wp-content/uploads/2015/07/dentiste-manhattan-ladefense.jpg', 'Courbevoie'),
(3, '16 rue Galilé', 'Appartement multi espace', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `local_espaces`
--

CREATE TABLE `local_espaces` (
  `local_id` int(11) NOT NULL,
  `espaces_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `espace_id` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `location`
--

INSERT INTO `location` (`id`, `end_date`, `start_date`, `espace_id`) VALUES
(1, '2017-07-08', '2017-07-03', 1),
(2, '2017-07-08', '2017-07-03', 1),
(4, '2017-07-08', '2017-07-03', 1),
(5, NULL, NULL, 2),
(6, '2017-06-23', '2017-06-21', 4);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `email`, `nom`, `password`, `prenom`, `telephone`) VALUES
(1, 'lea@lea.com', 'Dupond', 'lea', 'Lea', '0123456789'),
(4, 'paul@paul.com', 'Charles', 'paul', 'Paul', '0123456789'),
(6, '', '', '', '', ''),
(7, '', '', '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `user_espacealouer`
--

CREATE TABLE `user_espacealouer` (
  `user_id` bigint(20) NOT NULL,
  `espacealouer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user_espacealouer`
--

INSERT INTO `user_espacealouer` (`user_id`, `espacealouer_id`) VALUES
(1, 2),
(1, 3),
(4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `user_espace_loue`
--

CREATE TABLE `user_espace_loue` (
  `user_id` bigint(20) NOT NULL,
  `espace_loue_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user_espace_loue`
--

INSERT INTO `user_espace_loue` (`user_id`, `espace_loue_id`) VALUES
(1, 4),
(1, 5),
(1, 6);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `espace`
--
ALTER TABLE `espace`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK95q7n3oi69b9mbkvix0ft7di3` (`local_id`);

--
-- Index pour la table `espace_locations`
--
ALTER TABLE `espace_locations`
  ADD UNIQUE KEY `UK_mys57l0dgr5n5aho7ypndixaq` (`locations_id`),
  ADD KEY `FKeqtbet9fp7uioquk4m1tm1orr` (`espace_id`);

--
-- Index pour la table `local`
--
ALTER TABLE `local`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `local_espaces`
--
ALTER TABLE `local_espaces`
  ADD UNIQUE KEY `UK_c265fv0ng07jy8aw76l3i5owg` (`espaces_id`),
  ADD KEY `FK4gy62i8bxl3jpb20wigio00xn` (`local_id`);

--
-- Index pour la table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqq061iko6bj71xplh5v6qpuig` (`espace_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_espacealouer`
--
ALTER TABLE `user_espacealouer`
  ADD UNIQUE KEY `UK_3ejt0ba3mp42g6t4n58ba6oog` (`espacealouer_id`),
  ADD KEY `FK22bg3kuj2fnkc9qw3fcqg5y0o` (`user_id`);

--
-- Index pour la table `user_espace_loue`
--
ALTER TABLE `user_espace_loue`
  ADD UNIQUE KEY `UK_5mpugxv2ajb9p1h52gbrevu77` (`espace_loue_id`),
  ADD KEY `FK4d0tga2fegwx8yqjchtkjmpd1` (`user_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `espace`
--
ALTER TABLE `espace`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT pour la table `local`
--
ALTER TABLE `local`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `espace`
--
ALTER TABLE `espace`
  ADD CONSTRAINT `FK95q7n3oi69b9mbkvix0ft7di3` FOREIGN KEY (`local_id`) REFERENCES `local` (`id`);

--
-- Contraintes pour la table `espace_locations`
--
ALTER TABLE `espace_locations`
  ADD CONSTRAINT `FK26mqlq2cdjl0vhdrank7pn7hk` FOREIGN KEY (`locations_id`) REFERENCES `location` (`id`),
  ADD CONSTRAINT `FKeqtbet9fp7uioquk4m1tm1orr` FOREIGN KEY (`espace_id`) REFERENCES `espace` (`id`);

--
-- Contraintes pour la table `local_espaces`
--
ALTER TABLE `local_espaces`
  ADD CONSTRAINT `FK3nguavm9mfuawnht0gvs4fatu` FOREIGN KEY (`espaces_id`) REFERENCES `espace` (`id`),
  ADD CONSTRAINT `FK4gy62i8bxl3jpb20wigio00xn` FOREIGN KEY (`local_id`) REFERENCES `local` (`id`);

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `FKqq061iko6bj71xplh5v6qpuig` FOREIGN KEY (`espace_id`) REFERENCES `espace` (`id`);

--
-- Contraintes pour la table `user_espacealouer`
--
ALTER TABLE `user_espacealouer`
  ADD CONSTRAINT `FK22bg3kuj2fnkc9qw3fcqg5y0o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKjybffwsefgc696dsjhss18hu2` FOREIGN KEY (`espacealouer_id`) REFERENCES `local` (`id`);

--
-- Contraintes pour la table `user_espace_loue`
--
ALTER TABLE `user_espace_loue`
  ADD CONSTRAINT `FK8pm747edmicc0xaf6fd9509ym` FOREIGN KEY (`espace_loue_id`) REFERENCES `location` (`id`),
  ADD CONSTRAINT `FK4d0tga2fegwx8yqjchtkjmpd1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKp2sa4yrwuwgbphhnpah3djda7` FOREIGN KEY (`espace_loue_id`) REFERENCES `espace` (`id`);

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  cathedrales = [
    { nom: 'Notre-Dame de Paris', ville: 'Paris', departement: '75', validee: true },
    { nom: 'Cathédrale Notre-Dame de Chartres', ville: 'Chartres', departement: '28', validee: false },
    { nom: 'Cathédrale Saint-Étienne de Bourges', ville: 'Bourges', departement: '18', validee: true },
    { nom: 'Cathédrale Notre-Dame de Reims', ville: 'Reims', departement: '51', validee: true },
    { nom: 'Cathédrale Saint-Pierre de Beauvais', ville: 'Beauvais', departement: '60', validee: false },
    { nom: 'Cathédrale Saint-Pierre de Saint-Flour', ville: 'Saint-Flour', departement: '15', validee: true },
    { nom: 'Cathédrale Notre-Dame de Bayeux', ville: 'Bayeux', departement: '14', validee: true },
    { nom: 'Cathédrale Notre-Dame de Laon', ville: 'Laon', departement: '02', validee: true },
    { nom: 'Cathédrale Saint-Jean de Lyon', ville: 'Lyon', departement: '69', validee: false },
    { nom: 'Cathédrale Saint-Maurice d\'Angers', ville: 'Angers', departement: '49', validee: true },
    { nom: 'Cathédrale Saint-Bénigne de Dijon', ville: 'Dijon', departement: '21', validee: true },
    { nom: 'Cathédrale Saint-Pierre de Rennes', ville: 'Rennes', departement: '35', validee: true },
    { nom: 'Cathédrale Notre-Dame de Rouen', ville: 'Rouen', departement: '76', validee: true },
    { nom: 'Cathédrale Saint-Étienne de Limoges', ville: 'Limoges', departement: '87', validee: true },
    { nom: 'Cathédrale Saint-Pierre de Poitiers', ville: 'Poitiers', departement: '86', validee: true },
    { nom: 'Cathédrale Notre-Dame d\'Amiens', ville: 'Amiens', departement: '80', validee: true },
    { nom: 'Cathédrale Saint-Michel de Carcassonne', ville: 'Carcassonne', departement: '11', validee: true },
    { nom: 'Cathédrale Saint-Corentin de Quimper', ville: 'Quimper', departement: '29', validee: true },
    { nom: 'Cathédrale Saint-André de Bordeaux', ville: 'Bordeaux', departement: '33', validee: true },
    { nom: 'Cathédrale Notre-Dame-de-l\'Assomption de Clermont-Ferrand', ville: 'Clermont-Ferrand', departement: '63', validee: true },
    { nom: 'Cathédrale Saint-Bénigne de Dijon', ville: 'Dijon', departement: '21', validee: true },
    { nom: 'Cathédrale Saint-Jean-Baptiste de Lyon', ville: 'Lyon', departement: '69', validee: true },
    { nom: 'Cathédrale Notre-Dame de Rouen', ville: 'Rouen', departement: '76', validee: true },
    { nom: 'Cathédrale Saint-Pierre-et-Saint-Paul de Troyes', ville: 'Troyes', departement: '10', validee: true },
    { nom: 'Cathédrale Saint-Maurice d\'Angers', ville: 'Angers', departement: '49', validee: true },
    { nom: 'Cathédrale Notre-Dame-et-Saint-Privat de Mende', ville: 'Mende', departement: '48', validee: true },
    { nom: 'Cathédrale Saint-Trophime d\'Arles', ville: 'Arles', departement: '13', validee: true },
    { nom: 'Cathédrale Saint-Jean de Besançon', ville: 'Besançon', departement: '25', validee: true },
    { nom: 'Cathédrale Saint-Pierre de Poitiers', ville: 'Poitiers', departement: '86', validee: true },
    { nom: 'Cathédrale Notre-Dame de Bayeux', ville: 'Bayeux', departement: '14', validee: true },
    { nom: 'Cathédrale Sainte-Croix d\'Orléans', ville: 'Orléans', departement: '45', validee: true },
    { nom: 'Cathédrale Saint-Louis de Blois', ville: 'Blois', departement: '41', validee: true },
    { nom: 'Cathédrale Saint-Étienne de Limoges', ville: 'Limoges', departement: '87', validee: true },
    { nom: 'Cathédrale Saint-Étienne de Metz', ville: 'Metz', departement: '57', validee: true },
    { nom: 'Cathédrale Notre-Dame de Strasbourg', ville: 'Strasbourg', departement: '67', validee: true },
    { nom: 'Cathédrale Saint-Gervais-et-Saint-Protais de Soissons', ville: 'Soissons', departement: '02', validee: true },
    { nom: 'Cathédrale Notre-Dame de Laon', ville: 'Laon', departement: '02', validee: true },
    { nom: 'Cathédrale Notre-Dame-de-l\'Annonciation de Moulins', ville: 'Moulins', departement: '03', validee: true },
    { nom: 'Cathédrale Notre-Dame-de-l\'Assomption de Tulle', ville: 'Tulle', departement: '19', validee: true },
    { nom: 'Cathédrale Notre-Dame-et-Saint-Vaast d\'Arras', ville: 'Arras', departement: '62', validee: true },
    { nom: 'Cathédrale Sainte-Marie de Bayonne', ville: 'Bayonne', departement: '64', validee: true },
    { nom: 'Cathédrale Sainte-Réparate de Nice', ville: 'Nice', departement: '06', validee: true },
    { nom: 'Cathédrale Saint-Nazaire-et-Saint-Celse de Carcassonne', ville: 'Carcassonne', departement: '11', validee: true },
    { nom: 'Cathédrale Notre-Dame-de-l\'Annonciation de Nancy', ville: 'Nancy', departement: '54', validee: true },
    { nom: 'Cathédrale Saint-Maurice de Vienne', ville: 'Vienne', departement: '38', validee: true },
    { nom: 'Cathédrale Saint-Pierre-et-Saint-Paul de Saint-Claude', ville: 'Saint-Claude', departement: '39', validee: true },
    { nom: 'Cathédrale Saint-Siffrein de Carpentras', ville: 'Carpentras', departement: '84', validee: true },
    { nom: 'Cathédrale Saint-Louis de Versailles', ville: 'Versailles', departement: '78', validee: true },
    { nom: 'Cathédrale Notre-Dame-de-l\'Annonciation de Créteil', ville: 'Créteil', departement: '94', validee: true },
    { nom: 'Cathédrale Saint-Pierre de Saint-Flour', ville: 'Saint-Flour', departement: '15', validee: true },
    { nom: 'Cathédrale Notre-Dame de l\'Assomption de Clermont', ville: 'Clermont', departement: '60', validee: true },
    { nom: 'Cathédrale Saint-Charles-Borromée de Saint-Étienne', ville: 'Saint-Étienne', departement: '42', validee: true },
    { nom: 'Cathédrale Saint-Pierre-et-Saint-Paul de Nantes', ville: 'Nantes', departement: '44', validee: true },
    { nom: 'Cathédrale Notre-Dame de l\'Assomption de Rodez', ville: 'Rodez', departement: '12', validee: true },
    { nom: 'Cathédrale Notre-Dame-et-Saint-Vaast d\'Arras', ville: 'Arras', departement: '62', validee: true },
    { nom: 'Cathédrale Saint-Julien du Mans', ville: 'Le Mans', departement: '72', validee: true },
    { nom: 'Cathédrale Saint-Pierre de Montpellier', ville: 'Montpellier', departement: '34', validee: true },
    { nom: 'Cathédrale Saint-Just-et-Saint-Pasteur de Narbonne', ville: 'Narbonne', departement: '11', validee: true },
    { nom: 'Cathédrale Saint-Corentin de Saint-Brieuc', ville: 'Saint-Brieuc', departement: '22', validee: true },
    { nom: 'Cathédrale Notre-Dame de Saint-Dié', ville: 'Saint-Dié-des-Vosges', departement: '88', validee: true },
    { nom: 'Cathédrale Saint-Louis de Versailles', ville: 'Versailles', departement: '78', validee: true },
    { nom: 'Cathédrale Notre-Dame de l\'Annonciation de Moulins', ville: 'Moulins', departement: '03', validee: true },
    { nom: 'Cathédrale Saint-Front de Périgueux', ville: 'Périgueux', departement: '24', validee: true },
    { nom: 'Cathédrale Saint-Étienne de Sens', ville: 'Sens', departement: '89', validee: true },
    { nom: 'Cathédrale Sainte-Marie de Saint-Bertrand-de-Comminges', ville: 'Saint-Bertrand-de-Comminges', departement: '31', validee: true },
    { nom: 'Cathédrale Saint-Pierre de Saintes', ville: 'Saintes', departement: '17', validee: true },
    { nom: 'Cathédrale Sainte-Croix d\'Orléans', ville: 'Orléans', departement: '45', validee: true },
    { nom: 'Cathédrale Saint-Étienne de Toulouse', ville: 'Toulouse', departement: '31', validee: true },
    { nom: 'Cathédrale Saint-Gervais-et-Saint-Protais de Lectoure', ville: 'Lectoure', departement: '32', validee: true },
    { nom: 'Cathédrale Notre-Dame de l\'Assomption de Luçon', ville: 'Luçon', departement: '85', validee: true },
    { nom: 'Cathédrale Saint-Caprais d\'Agen', ville: 'Agen', departement: '47', validee: true },
    { nom: 'Cathédrale Notre-Dame-de-l\'Annonciation de Nancy', ville: 'Nancy', departement: '54', validee: true },


  ];



  constructor() { }
  getCathedrales() {
    return this.cathedrales;
  }
}

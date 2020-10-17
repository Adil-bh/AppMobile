# Application FootResults
## Présentation

Projet application mobile utilisant la clean architecture et le pattern MVC codée en Java.

La récupération de données s'effectue avec une API Rest. 

J'ai donc choisi comme API [Score Bat Video API](https://www.scorebat.com/video-api/)
afin de récupérer des données sur les derniers matchs joués mais aussi ajouter une vidéo résumé du match.

## Prérequis

- Installation d'Android Studio
- Récuperer notre branche de développement Git sur Android Studio
```bash
https://github.com/Adil-bh/AppMobile
```

- Utiliser une API Rest (Parmis les exemples ou non)
```bash
https://github.com/public-apis/public-apis
 ```
 
 ## Consignes respectées 

- Clean architecture MVC
- Appel API Rest
- Affichage d'une liste RecyclerView
- Affichage du détail dans un pop-up
- Sauvegarde des données dans le cache
- Gitflow propre
- Fonctionnalité Supplémentaire :
  - Vidéo Youtube 
  
## Fonctionnalités

### Écran d'accueil

- Affichage de la liste des matchs
- Date de la rencontre
- Logo du championnat

|<img src="https://github.com/Adil-bh/AppMobile/blob/master/img_readme/liste.png" width="350"> |
|----------------------------------------------------------------------------------------------|

### Pop-up détail du match
- Équipe à domicile 
- Équipe à l'extérieur 
- Vidéo highlights

| <img src="https://github.com/Adil-bh/AppMobile/blob/master/img_readme/atletico_popup.png" width="350"> | <img src="https://github.com/Adil-bh/AppMobile/blob/master/img_readme/atleticofullscreen.png" width="350"> | <img src="https://github.com/Adil-bh/AppMobile/blob/master/img_readme/real_popup.png" width="350"> | 
| ------------ | ------------- |------------- |

### Mise en cache des données
- Lecture des vidéos depuis internet
- Mise de en cache de la mémoire



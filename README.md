# Android Xml Parsing

This an Android application with XML parsing codes.

The url I have used is available in values/string.xml file.

The application check internet connection as well. If there is no connection, it shows some TOAST message such as:

![screenshot_20160824-150810](https://cloud.githubusercontent.com/assets/11629459/18271984/d7281ede-743d-11e6-9589-9bb229635c7e.png)

If there is internet connection; the application show a dialog while parsing data from the internet (Loading, please wait...)

![screenshot_20160824-150810](https://cloud.githubusercontent.com/assets/11629459/18271983/d726a45a-743d-11e6-871e-8380bd511e66.png)

When finished, it shows all data in two different Textviews (title, description)

![screenshot_20160824-150810](https://cloud.githubusercontent.com/assets/11629459/18271985/d72b47ee-743d-11e6-9dc7-04bf519df35f.png)


If data first loaded it does not let you load it again. I created a flag called _"isTaskExecuted"_ which does not let execute task again.

This app shows **monthly** horoscope information, if you like you can change it to daily, yearly etc.

Hope it helps someone :+1: :) If you want to see some real project I have created with XML parsing codes, please check my android [daily horoscope ]( https://play.google.com/store/apps/details?id=ercanduman.dailyhoroscope) application.


Ercan DUMAN

Computer engineer, Android Developer

For more android apps [visit](https://play.google.com/store/search?q=ercanduman)

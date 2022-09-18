# kursat-kumuz-week4-homework

*  `Espresso` for testing
*  `Mockito` for testing
*  `Truth` for testing
*  `Hilt` for dependency injection
*  `Room` for database
*  `Retrofit` for GET request
*  `Coroutines` for asynchronous programming
*  `MVVM` for architecture
*  `Lottie` for animation


## 📸 GIF
<p align="center">
<img src="https://media.giphy.com/media/9cHEwvJV8GJPxYO3eh/giphy.gif">
 </p>

## FeedFragment

RecyclerView scroll ettirildiğinde animasyon aktif hale gelir. RecyclerView'ın herhangi bir item'ımına tıklanıldığında DetailFragment'a gidilir ve aynı zamanda tıklanılan item'ın verisi de parcelable şeklinde DetailFragment'a aktarılır. En üst sağ kısımda Cart butonu bulur ve tıklanıldığında CartFragment'a gidilir.

<p align="center">
<img src="https://media.giphy.com/media/bJFo6f59tew5SAhcvE/giphy.gif">
 </p>
 
 
## DetailFragment

RecyclerView'da tıklanılan item'ın detayları gösterilir. Add to cart butonuna tıklanıldığında ekranda gösterilen tüm veriler room database'e kaydedilir. Eğer aynı id numarasına sahip bir veri zaten kaydedilmiş ise toast mesajı gösterilerek önceden eklendiği kullanıcıya bildirilir.

<p align="center">
<img src="https://media.giphy.com/media/bjAeroo6bspqFKIWkN/giphy.gif">
 </p>

## CartFragment

DetailFragment'ta eklenen tüm veriler burada RecyclerView içinde gösterilir. Kullanıcı silmek istediği item'ı sola sürüklerse silebilir. RecyclerView'da silme işlemi yapıldığında bu işlemin algılanıp güncellenmesi için Adapter içerisinde DiffUtil kullanılmıştır. Buy butonuna basarsa tüm data satın alındığı için room database'den silinir.

<p align="center">
<img src="https://media.giphy.com/media/Kl06rb4XbCP5QZ3Cgq/giphy.gif">
 </p>





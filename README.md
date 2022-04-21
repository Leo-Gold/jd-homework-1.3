# Домашняя работа
## 1.3 Потоки ввода-вывода. Работа с файлами. Сериализация
### задача 1
* смоделируете процесс установки игры на жесткий диск компьютера
##### этапы:
- [x] В папке Games создайте несколько директорий: src, res, savegames, temp.
- [x] В каталоге src создайте две директории: main, test.
- [x] В подкаталоге main создайте два файла: Main.java, Utils.java.
- [x] В каталог res создайте три директории: drawables, vectors, icons.
- [x] В директории temp создайте файл temp.txt.
- [x] Файл temp.txt будет использован для записи в него информации об успешном или неуспешном создании файлов и директорий.

### задача 2
* записывать сериализованные файлы на жесткий диск
* упаковать их в архив 

-[x] Создать три экземпляра класса GameProgress.
-[ ] Сохранить сериализованные объекты GameProgress в папку savegames из предыдущей задачи.
-[ ] Созданные файлы сохранений из папки savegames запаковать в архив zip.
-[ ] Удалить файлы сохранений, лежащие вне архива.
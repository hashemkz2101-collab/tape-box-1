# مدیریت تپه — نسخه اندروید (WebView، دو لینک)

این اپ یک صفحه‌ی اول دارد با دو دکمه؛ با زدن روی هرکدام، همان صفحه‌ی گوگل اسکریپت مربوطه
داخل یک WebView باز می‌شود. آپلود عکس، دوربین، فرم‌ها و بقیه‌ی منطق برنامه همان کدهایی
هستند که در Apps Script / HTML خودتان نوشته‌اید — این پروژه فقط یک "پوسته" اندرویدی دور
آن‌ها می‌کشد.

## مراحل ساخت APK با گیت‌هاب (بدون نیاز به نصب چیزی روی کامپیوتر خودتان)

1. یک ریپازیتوری جدید در GitHub بسازید (مثلاً `tape-app`).
2. تمام فایل‌های این پوشه (همینطور که هست، با پوشه‌ی `.github`) را در آن ریپازیتوری آپلود/پوش کنید.
3. به تب **Actions** بروید — ورک‌فلو «Build APK» به‌صورت خودکار اجرا می‌شود.
4. چند دقیقه صبر کنید تا اجرا تمام شود (علامت سبز ✅).
5. روی همان اجرا کلیک کنید؛ در بخش **Artifacts** فایلی به نام `tape-app-debug-apk` را
   دانلود کنید. داخلش `app-debug.apk` است.
6. آن APK را روی گوشی منتقل و نصب کنید (باید نصب از منابع ناشناس را اجازه بدهید).

## تغییر اسم دو برنامه روی صفحه‌ی اول

فعلاً اسم‌ها به‌صورت پیش‌فرض «برنامه ۱» و «برنامه ۲» هستند. برای عوض کردن، فایل زیر را باز
کنید و مقدار دو رشته‌ی `app1_name` و `app2_name` را به اسم دلخواه‌تان تغییر دهید:

```
app/src/main/res/values/strings.xml
```

مثال:
```xml
<string name="app1_name">مدیریت تپه — انبار اصلی</string>
<string name="app2_name">مدیریت تپه — انبار دوم</string>
```

## تغییر آدرس لینک‌ها

اگر لینک‌های دیپلوی گوگل اسکریپت عوض شدند، فایل زیر را باز کنید و مقدار `URL_1` و `URL_2` را
عوض کنید:

```
app/src/main/java/com/mahroch/tapeapp/AppLinks.java
```

بعد از هر تغییر و پوش کردن، اکشن گیت‌هاب به‌صورت خودکار نسخه‌ی جدید APK را می‌سازد.

## نکات مهم

- این یک بیلد **Debug** است (بدون امضای Release)؛ برای نصب روی گوشی خودتان کافی است، ولی
  برای انتشار در Google Play باید امضا (signing) و بیلد Release جداگانه انجام شود.
- دسترسی دوربین (`CAMERA`) و اینترنت در `AndroidManifest.xml` از قبل اضافه شده تا آپلود
  عکس از داخل فرم‌های HTML شما کار کند.
- دکمه‌ی بازگشت گوشی، اول در خود صفحه‌ی وب عقب می‌رود؛ اگر صفحه‌ی وب چیزی برای برگشتن نداشته
  باشد، به صفحه‌ی انتخاب (لیست دو برنامه) برمی‌گردد.

## App icon

The launcher icon uses the supplied `icon.jpg` artwork. Density-specific PNG launcher icons are stored under `app/src/main/res/mipmap-*`, and `AndroidManifest.xml` points to `@mipmap/ic_launcher`.

## GitHub Actions build

The included workflow at `.github/workflows/build.yml` builds both Debug and unsigned Release APKs on pushes to `main` or from **Actions → Build APK → Run workflow**. The generated APKs are available under the workflow's **Artifacts** section.

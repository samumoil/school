# How to use UEF eduroam with Linux

Setting up eduroam on linux required a few steps. Here we go:

1. Download eduroam certificate installer [https://kamu.uef.fi/tyokalut/langattomat-verkot-uefissa/](https://kamu.uef.fi/tyokalut/langattomat-verkot-uefissa/)
2. Open terminal and go to Downloads folder, probably `/home/<user>/Downloads`. 
3. Run certificate downloader with `python <name of downloaded file>.py`.
4. Open NetworkManager and double click "eduroam"
5. Click folder icon next to "CA Certificate" and locate the newly created certificate file. Usually it is in `/home/<user>/.config/...`. (If you can't find `.config` folder, activate "Show hidde files" from right click dropdown menu.)
6. Add username and password to respective fields and login.
7. Enjoy!

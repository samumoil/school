# How to use UEF eduroam with Debian/Ubuntu based Linux distros

Setting up eduroam on linux requires a few steps. Here we go:

0. Install python with `sudo apt install python3`
1. Download eduroam certificate installer from eduroam page, choose "Itä-Suomen yliopisto": [https://kamu.uef.fi/tyokalut/langattomat-verkot-uefissa/](https://kamu.uef.fi/tyokalut/langattomat-verkot-uefissa/)
	- You can also use this link, though it may break in the future: [https://cat.eduroam.org/user/API.php?action=downloadInstaller&lang=fi&profile=2063&device=linux&generatedfor=user&openroaming=0](https://cat.eduroam.org/user/API.php?action=downloadInstaller&lang=fi&profile=2063&device=linux&generatedfor=user&openroaming=0)
	- You may also use the provided file in this repo. You probably shoudn't because running random scripts from internet is dangerous!
2. Open terminal and go to Downloads folder, probably `/home/<user>/Downloads`. 
3. Run certificate downloader with `python eduroam-linux-Ita-Suomen_yliopisto.py`.
4. Open NetworkManager and double click "eduroam"
5. Click folder icon next to "CA Certificate" and locate the newly created certificate file. Usually it is in `/home/<user>/.config/cat_installer/ca.pem`. (If you can't find `.config` folder, activate "Show hidden files" from right click dropdown menu.)
6. Add username <user>@uef.fi and password to respective fields and login.
7. Enjoy!

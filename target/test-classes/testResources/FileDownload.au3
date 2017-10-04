; wait for 8 seconds to appear download and save dialog. Used class property of download dialog.
WinWait("[CLASS:#MozillaDialogClass]","",8)
; Perform keyboard ALT key + s key to select Save File Radio button using keyboard shortcut.
Send("!s")
; Wait for 4 seconds
Sleep(400)
Send("{ENTER}")

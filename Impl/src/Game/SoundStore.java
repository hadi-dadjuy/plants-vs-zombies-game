package Game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.HashMap;

public class SoundStore
{
	private static SoundStore	single			=new SoundStore();
	private static String		SoundFiles[]	= { Sounds.BG,Sounds.Score , Sounds.Wined,Sounds.Pea,Sounds.Plant,Sounds.Boom,Sounds.GameOver,Sounds.Eat,Sounds.BombFall};
	
	public static SoundStore get()
	{
		return single;
	}
	
	private HashMap<String, AudioClip>	sounds;
	
	public void LoadSounds()
	{
		sounds=new HashMap<String, AudioClip>();
		for (int i=0 ; i<SoundFiles.length ; i++)
		{
			AudioClip clip=Applet.newAudioClip(this.getClass().getResource(SoundFiles[i]));
			sounds.put(SoundFiles[i] , clip);
		}
	}
	
	public void Play(String ref)
	{
		if (sounds.get(ref)!=null)
			((AudioClip) sounds.get(ref)).play();
	}
	public void stop(String ref)
	{
		if (sounds.get(ref)!=null)
			((AudioClip) sounds.get(ref)).stop();
	}

}// End of Class
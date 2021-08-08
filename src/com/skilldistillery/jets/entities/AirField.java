package com.skilldistillery.jets.entities;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AirField {
	
	private List<Jet>jets = new ArrayList<>();
	
	
	public AirField(List<Jet> jets) {
		super();
		this.jets = jets;
	}
	
	public AirField() {
		jets = new ArrayList<>();
	}

	public List<Jet> loadAirField() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("Jets.txt"))) {
			String moreJets;
			Jet jet = null;
			while ((moreJets = bufIn.readLine()) != null) {
				// JetFighter,Mikoyan-Gurevich MiG-28,670,1100,40625000
				String[] pieces = moreJets.split(",");
				if (pieces[0].equals("FighterJet")) {
					jet = new FighterJet(pieces[1], Double.parseDouble(pieces[2]), Integer.parseInt(pieces[3]),
							Long.parseLong(pieces[4]));
				}
					else if (pieces[0].equals("PrivateJet")) {
						jet = new JetImpl(pieces[1], Double.parseDouble(pieces[2]), Integer.parseInt(pieces[3]),
								Long.parseLong(pieces[4]));
					}
						else if (pieces[0].equals("CargoPlane")) {
							jet = new CargoPlane(pieces[1], Double.parseDouble(pieces[2]), Integer.parseInt(pieces[3]),
									Long.parseLong(pieces[4]));
						jets.add(jet);

				}
				System.out.println(jet);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
		
	}

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	
	}

	@Override
	public String toString() {
		return "AirField [jets=" + jets + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(jets);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirField other = (AirField) obj;
		return Objects.equals(jets, other.jets);
	}


}

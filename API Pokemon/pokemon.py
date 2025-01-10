import requests
import json

API_URL = "https://pokeapi.co/api/v2/pokemon/"
pokemons_list = []

def get_pokemon_data():
    try:
        
        params = {"language": "en", }  
        response = requests.get(API_URL+pokemon, params=params)
        
        if response.status_code == 200:
            data = response.json()  
            pretty_data = json.dumps(data, indent=4, ensure_ascii=False)  

            for key, value in data.items():
                if key != "cries" and key != "sprites":
                    print(f"{key}:")
                if key == "abilities":
                    for ability_data in value:
                        print(f"  {ability_data['ability']['name'].replace('-', ' ').title()}")
                elif key == "base_experience":
                    print(f"  {value} points")
                #elif key == "cries":
                #    print(f"  {value['audio']}")
                elif key == "forms":
                    for form_data in value:
                        print(f"  {form_data['name']}")
                elif key == "height":
                    print(f"  {value} decimetres")
                elif key == "id":
                    print(f"  {value}")
                elif key == "is_default":
                    print(f"  {value}")
                elif key == "location_area_encounters":
                    locations = requests.get(value)
                    locations_data = locations.json()
                    for location_data in locations_data:
                        print(f"  {location_data['location_area']['name'].replace('-', ' ').title()}")
                elif key == "moves":
                    for move_data in value:
                        print(f"  {move_data['move']['name'].replace('-', ' ').title() }")
                elif key == "name":
                    print(f"  {value}")
                elif key == "order":
                    print(f"  {value}")
                elif key == "past_abilities":
                    for past_ability_data in value:
                        print(f"  {past_ability_data['ability']['name'].replace('-', ' ').title()}")
                elif key == "past_types":
                    for past_type_data in value:
                        print(f"  {past_type_data['type']['name'].replace('-', ' ').title()}")
                elif key == "species":
                    print(f"  {value['name']}")
               # elif key == "sprites":
                #    for sprite_data in value:
                 #       print(f"  {sprite_data['front_default']}")
                elif key == "stats":
                    for stat_data in value:
                        print(f"  {stat_data['stat']['name'].replace('-', ' ').title()}: {stat_data['base_stat']}")
                elif key == "types":
                    for type_data in value:
                        print(f"  {type_data['type']['name'].replace('-', ' ').title()}")
                elif key == "weight":
                    print(f"  {value} hectograms")
            #print(pretty_data)
        else:
            print(f"Error: HTTP {response.status_code}")
    except requests.exceptions.RequestException as e:
        print(f"Error al conectar con la API: {e}")

def get_pokemons():
    try:
        response = requests.get(API_URL)
        if response.status_code == 200:
            data = response.json()
            pokemons_list.clear()
            pokemons_list.append(data["results"])   

        else:
            print(f"Error: HTTP {response.status_code}")
    except requests.exceptions.RequestException as e:
        print(f"Error al conectar con la API: {e}")


if __name__ == "__main__":
    get_pokemons()
    while(True):
        print("\nPokemon API")
        print("Write a pokemon name to get data or 'exit' to exit")
        print("Write 'list' to get a list of pokemons")
        pokemon = input("Pokemon: ")

        if pokemon == "exit":
            break 
        elif pokemon == "list": 
            for pokemon in pokemons_list[0]:
                print(pokemon["name"])
            continue
        elif pokemon in [pokemon["name"] for pokemon in pokemons_list[0]]:
            print("\n\nPokemon data:")
            get_pokemon_data()
        else:    
            print("Pokemon not found")
            continue

        
        
           
        

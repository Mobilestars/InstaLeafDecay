# 🍃 InstaLeafDecay

A Minecraft **Spigot/Paper plugin module** that allows leaves to **decay instantly** when logs are broken or nearby leaves decay.  
This enhances tree-farming gameplay by speeding up leaf removal while respecting natural decay mechanics.

---

## ⚙️ Features

- 🚀 **Instant leaf decay** when breaking logs  
- 🍂 Automatically breaks leaves when nearby leaves decay naturally  
- 🌿 Prevents persistent leaves (e.g., player-placed) from decaying  
- ⚡ Lightweight and efficient — uses optimized recursive checks  
- 📏 Limits leaf breaking to a configurable distance internally for performance  

---

## 📁 Installation

1. Include this module/plugin `.jar` in your server’s `plugins/` folder  
2. Start or reload your server  
3. Works immediately — no configuration needed  

---

## 🧩 Developer Information

**Main listener class:**  
`de.scholle.minecrafthelden.external.InstaLeafDecay.BlockBreakEventListener`

**Key methods & behavior:**
- `onBlockBreak(BlockBreakEvent event)` → Breaks leaves near broken logs instantly  
- `onLeavesDecay(LeavesDecayEvent event)` → Breaks nearby leaves instantly during natural decay  
- `breakLeaf(Block block, boolean breakFirstBlock, Block originalBlock)` → Recursively handles leaf breaking  
- `isValidLeaf(Block block, Block originalBlock)` → Ensures leaves are valid for decay, ignoring persistent or distant blocks  

**Notes:**  
- Persistent leaves are ignored to prevent accidental removal of player-placed foliage  
- Uses a taxicab-distance based check to optimize performance  

---

## 🧰 Compatibility

- ✅ Works on **Spigot**, **Paper**, and **Purpur**  
- 🧱 Compatible with **Minecraft 1.18+**  
- ⚙️ Requires **Java 17+**

---

## 🧑‍💻 Author

**Developed by:** Scholle  
**Package:** `de.scholle.minecrafthelden.external.InstaLeafDecay`

---

## 📜 License

This project is licensed under the **Apache License 2.0**.  
You may use, modify, and distribute it in compliance with the terms of that license.  
For more information, see: [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)
